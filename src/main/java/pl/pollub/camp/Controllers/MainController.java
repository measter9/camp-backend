package pl.pollub.camp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Repositories.UserRepository;
import pl.pollub.camp.Models.Users;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String password, @RequestParam String email){
        Users u = new Users();
        u.setName(name);
        u.setPassword(password);
        u.setEmail(email);

        userRepository.save(u);
        return "User succesfully created";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Users> getAllUsers(){
        return userRepository.findAll();
    }
}
