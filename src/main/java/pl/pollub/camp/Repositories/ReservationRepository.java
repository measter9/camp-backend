package pl.pollub.camp.Repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pollub.camp.Models.Reservations;

public interface ReservationRepository extends CrudRepository<Reservations, Integer> {
}
