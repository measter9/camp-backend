package pl.pollub.camp.Services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.camp.Models.Prices;
import pl.pollub.camp.Repositories.PriceRepository;
import java.util.List;

@Service
public class PriceService{
    @Autowired
    private PriceRepository priceRepository;
    public Prices addPrice(Double price, java.sql.Date start, java.sql.Date end){
        Prices prices = new Prices();
        prices.setPrice(price);
        prices.setStart(start);
        prices.setEnd(end);
        return priceRepository.save(prices);
    }

    public List<Prices> getAllPrices() {
        return (List<Prices>) priceRepository.findAll();
    }

    public Prices updatePrice(int id, Double price, java.sql.Date start, java.sql.Date end){
        Prices prices = priceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Price not found with id " + id));
        prices.setPrice(price);
        prices.setStart(start);
        prices.setEnd(end);
        return priceRepository.save(prices);
    }

    public String deletePrice(int id){
        if (!priceRepository.existsById(id)) {
            throw new EntityNotFoundException("Price not found with id " + id);
        }
        priceRepository.deleteById(id);
        return "Price deleted successfully";
    }
}
