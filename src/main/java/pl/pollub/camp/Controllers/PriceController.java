package pl.pollub.camp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pollub.camp.Models.Prices;
import pl.pollub.camp.Services.PriceService;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/prices")
public class PriceController {
    @Autowired
    private PriceService pricesService;

    @PostMapping(path = "/add")
    public Prices addPrice(@RequestParam Double price, @RequestParam Date start, @RequestParam Date end) {
        return pricesService.addPrice(price, start, end);
    }

    @GetMapping(path = "/all")
    public List<Prices> getAllPrices() {
        return pricesService.getAllPrices();
    }

    @PatchMapping(path = "/update")
    public Prices updatePrice(@RequestParam int id, @RequestParam Double price, @RequestParam Date start, @RequestParam Date end) {
        return pricesService.updatePrice(id, price, start, end);
    }

    @DeleteMapping(path = "/delete")
    public String deletePrice(@RequestParam int id) {
        return pricesService.deletePrice(id);
    }
}

