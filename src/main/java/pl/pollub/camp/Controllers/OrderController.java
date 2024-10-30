package pl.pollub.camp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Models.OrderStatus;
import pl.pollub.camp.Models.Orders;
import pl.pollub.camp.Models.Users;
import pl.pollub.camp.Repositories.OrderRepository;
import pl.pollub.camp.Repositories.UserRepository;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

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
