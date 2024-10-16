package pl.pollub.camp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Models.OrderStatus;
import pl.pollub.camp.Models.Orders;
import pl.pollub.camp.Models.Role;
import pl.pollub.camp.Repositories.OrderRepository;
import pl.pollub.camp.Repositories.UserRepository;
import pl.pollub.camp.Models.Users;

import java.util.Optional;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path = "/addUser")
    public @ResponseBody String addUser(@RequestParam String name, @RequestParam String password, @RequestParam String email){
        Users u = new Users();
        u.setName(name);
        u.setPassword(password);
        u.setEmail(email);
        u.setRole(Role.CUSTOMER);
        userRepository.save(u);
        return "User succesfully created";
    }

    @GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<Users> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping(path = "/addOrder")
    public @ResponseBody String addOrder(@RequestParam String commnet, @RequestParam int userId){
        Users u = userRepository.findById(userId).orElse(null);

        Orders o = new Orders();
        o.setComment(commnet);
        o.setOrderStatus(OrderStatus.PENDING);
        o.setUser(u);
        orderRepository.save(o);
        return "Order sucesfully created";
    }
    @GetMapping(path = "/allOrders")
    public @ResponseBody Iterable<Orders> getAllOrders(){
        return orderRepository.findAll();
    }
}
