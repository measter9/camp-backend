package pl.pollub.camp.Services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import pl.pollub.camp.Models.*;
import pl.pollub.camp.Models.DTO.FilterVehiclesRequset;
import pl.pollub.camp.Models.DTO.ReservationRequest;
import pl.pollub.camp.Repositories.OrderRepository;
import pl.pollub.camp.Repositories.ReservationRepository;
import pl.pollub.camp.Repositories.UserRepository;
import pl.pollub.camp.Repositories.VehicleRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class ReservationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public String makeReservation(HttpServletRequest request, @RequestBody ReservationRequest reservationRequest) {
        Users u = userRepository.findByName((String) request.getAttribute("Username")).orElse(null);
        Vehicles v = vehicleRepository.findById(reservationRequest.getVehicleId()).orElse(null);
        if (u != null && v != null) {
            Orders o = new Orders();
            o.setUser(u);
            o.setComment(reservationRequest.getComments());
            o.setOrderStatus(OrderStatus.PENDING);

            Reservations r = new Reservations();
            r.setStart(reservationRequest.getReservationStartDate());
            r.setEnd(reservationRequest.getReservationEndDate());
            r.setLocation(reservationRequest.getLocation());
            r.setOrder(o);
            r.setVehicle(v);

            orderRepository.save(o);
            reservationRepository.save(r);

            return "Success";
        }

        return "Could not find user or vehicle";
    }

    public Iterable<Vehicles> showAvailableCampers(@RequestBody FilterVehiclesRequset filterVehiclesRequset) {
        Iterable<Reservations> reservations = reservationRepository.findByStartBetweenAndEndBetween(filterVehiclesRequset.getBegining(), filterVehiclesRequset.getEnd(), filterVehiclesRequset.getBegining(), filterVehiclesRequset.getEnd());
        List<Integer> occupiedVehiclesIds = new ArrayList<>();
        for (Reservations r : reservations) {
            occupiedVehiclesIds.add(r.getVehicle().getId());
        }
        Iterable<Vehicles> availableVehicles = vehicleRepository.findByIdNotIn(occupiedVehiclesIds);
        return availableVehicles;
    }

    public Iterable<Reservations> showUserReservations(@RequestParam int userid) {
        return reservationRepository.findByOrderUserId(userid);
    }

    public String removeReservation(HttpServletRequest httpServletRequest, int id) {
        Reservations r = reservationRepository.findById(id).orElse(null);
        if (r == null ||
                r.getOrder().getUser().getEmail() == httpServletRequest.getAttribute("email") ||
                httpServletRequest.getAttribute("Role") == Role.ADMIN) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            reservationRepository.delete(r);
            orderRepository.delete(r.getOrder());
            return "Success";
        }

    }
}
