package pl.pollub.camp.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Models.DTO.FilterVehiclesRequset;
import pl.pollub.camp.Models.DTO.ReservationRequest;
import pl.pollub.camp.Models.Reservations;
import pl.pollub.camp.Models.Vehicles;
import pl.pollub.camp.Repositories.ReservationRepository;
import pl.pollub.camp.Services.ReservationService;

@RestController
@RequestMapping(path = "/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> makeReservation(HttpServletRequest httpServletRequest, @RequestBody ReservationRequest reservationRequest){
        return ResponseEntity.ok(reservationService.makeReservation(httpServletRequest,reservationRequest));
    }
    @GetMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody Iterable<Reservations> showAllReservations(){
        return reservationRepository.findAll();
    }

    @GetMapping(path = "/find")
    public @ResponseBody Iterable<Vehicles> showAvailableVehicles(@RequestBody FilterVehiclesRequset filterVehiclesRequset){
        return reservationService.showAvailableCampers(filterVehiclesRequset);
    }
}

