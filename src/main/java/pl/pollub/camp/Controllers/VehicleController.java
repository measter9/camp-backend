package pl.pollub.camp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Models.Vehicles;
import pl.pollub.camp.Models.VehicleStatus;
import pl.pollub.camp.Models.VehicleType;
import pl.pollub.camp.Repositories.VehicleRepository;

@Controller
@RequestMapping(path = "/vehicle")
public class VehicleController {
    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping(path = "/addVehicle")
    public @ResponseBody String addVehicle(@RequestParam String name, @RequestParam String commnet) {
        Vehicles v = new Vehicles();
        v.setName(name);
        v.setComment(commnet);
        v.setVehicleStatus(VehicleStatus.PENDING);
        //v.setVehicleTypeList(vehicleType);
        vehicleRepository.save(v);
        return "Kamper succesfully created";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Vehicles> getAllUsers() {
        return vehicleRepository.findAll();

    }
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteUser(@RequestParam int id){
        vehicleRepository.deleteById(id);
        return "Kamper succesfully deleted";
    }
    @PatchMapping(path = "/update")
    public @ResponseBody String updateUser(@RequestParam(required = false) String name, @RequestParam int id){
        Vehicles v = vehicleRepository.findById(id).orElse(null);
        if(v!=null){
            v.setName(name);
            vehicleRepository.save(v);
            return v.getName();
        }
        return "Kamper not found";
    }
}

