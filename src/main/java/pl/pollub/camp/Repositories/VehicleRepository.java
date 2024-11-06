package pl.pollub.camp.Repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import pl.pollub.camp.Models.Vehicles;

import java.util.Collection;
import java.util.Optional;

public interface VehicleRepository extends CrudRepository<Vehicles, Integer> {
    Iterable<Vehicles> findByIdNotIn(Collection<Integer> integer);
}
