package pl.pollub.camp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Models.Role;
import pl.pollub.camp.Repositories.UserRepository;
import pl.pollub.camp.Models.Users;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String password, @RequestParam String email){
        Users u = new Users();
        u.setName(name);
        u.setPassword(password);
        u.setEmail(email);
        u.setRole(Role.CUSTOMER);
        userRepository.save(u);
        return "User succesfully created";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Users> getAllUsers(){
        return userRepository.findAll();
    }
    @DeleteMapping(path = "/delete")
    public @ResponseBody String deleteUser(@RequestParam int id){
        userRepository.deleteById(id);
        return "User succesfully deleted";
    }
    @PatchMapping(path = "/update")
    public @ResponseBody String updateUser(@RequestParam(required = false) String name, @RequestParam int id){
        Users u = userRepository.findById(id).orElse(null);
        if(u!=null){
            u.setName(name);
            userRepository.save(u);
            return u.getName();
        }
        return "User not found";
    }

}
