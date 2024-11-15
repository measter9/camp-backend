package pl.pollub.camp.Controllers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Models.Vehicles;
import pl.pollub.camp.Services.VehicleService;
import pl.pollub.camp.Models.VehicleStatus;
import pl.pollub.camp.Services.VehicleService;
import pl.pollub.camp.Repositories.VehicleRepository;
import pl.pollub.camp.Models.DTO.VehicleRequest;

@Controller
@RequestMapping(path = "/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping(path = "/add")
    public @ResponseBody String addVehicle(@RequestBody VehicleRequest vehicleRequest) {
        try {
            return vehicleService.addVehicle(vehicleRequest);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Vehicles> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteVehicle(@RequestParam int id) {
        try {
            return vehicleService.deleteVehicle(id);
        } catch (EntityNotFoundException e) {
            return e.getMessage();
        }
    }

    @PatchMapping(path = "/update")
    public @ResponseBody String updateVehicle(@RequestParam int id, @RequestBody VehicleRequest updatedVehicleRequest) {
        try {
            Vehicles updatedVehicle = vehicleService.updateVehicle(id, updatedVehicleRequest);
            return "Vehicle updated: " + updatedVehicle.getName();
        } catch (EntityNotFoundException e) {
            return e.getMessage();
        }
    }
}

