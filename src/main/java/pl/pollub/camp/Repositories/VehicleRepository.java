package pl.pollub.camp.Repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import pl.pollub.camp.Models.Vehicles;

public interface VehicleRepository extends CrudRepository<Vehicles, Integer> {
}
