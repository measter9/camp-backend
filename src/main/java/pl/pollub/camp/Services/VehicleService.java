package pl.pollub.camp.Services;

import jakarta.persistence.EntityNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.camp.Models.DTO.VehicleRequest;
import pl.pollub.camp.Models.Vehicles;
import pl.pollub.camp.Repositories.VehicleRepository;

@Service
@NoArgsConstructor
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public String addVehicle( VehicleRequest vehicleRequest) {
        if (vehicleRequest.getVehicleType() == null) {
            throw new IllegalArgumentException("Vehicle type must be provided");
        }
        Vehicles vehicle = new Vehicles();
        vehicle.setName(vehicleRequest.getName());
        vehicle.setDescription(vehicleRequest.getDescription());
        vehicle.setVehicleStatus(vehicleRequest.getVehicleStatus());
        vehicle.setComment(vehicleRequest.getComment());
        vehicle.setVehicleType(vehicleRequest.getVehicleType());

        vehicleRepository.save(vehicle);
        return "Vehicle added successfully";
    }

    public String deleteVehicle(int id) {
        if (!vehicleRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicle not found with id " + id);
        }
        vehicleRepository.deleteById(id);
        return "Vehicle deleted successfully";
    }

    public Vehicles updateVehicle(int id, VehicleRequest updatedVehicleRequest) {
        Vehicles vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id " + id));
        vehicle.setName(updatedVehicleRequest.getName());
        vehicle.setDescription(updatedVehicleRequest.getDescription());
        vehicle.setVehicleStatus(updatedVehicleRequest.getVehicleStatus());  // Remove duplicate setting of vehicleStatus
        vehicle.setComment(updatedVehicleRequest.getComment());
        if (updatedVehicleRequest.getVehicleType() != null) {
            vehicle.setVehicleType(updatedVehicleRequest.getVehicleType());
        }
        return vehicleRepository.save(vehicle);
    }


    public Iterable<Vehicles> getAllVehicles() {
        return vehicleRepository.findAll();
    }

}