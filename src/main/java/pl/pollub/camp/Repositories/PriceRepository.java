package pl.pollub.camp.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pollub.camp.Models.Prices;
import pl.pollub.camp.Models.VehicleType;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PriceRepository extends CrudRepository<Prices, Integer> {
    List<Prices> findByVehicleTypeAndStartBetweenOrEndBetweenOrderByPriceDesc(VehicleType vehicleType, Date start1, Date end1, Date start2, Date end2);

}
