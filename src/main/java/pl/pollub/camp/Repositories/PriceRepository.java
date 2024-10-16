package pl.pollub.camp.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pollub.camp.Models.Prices;

public interface PriceRepository extends CrudRepository<Prices, Integer> {
}
