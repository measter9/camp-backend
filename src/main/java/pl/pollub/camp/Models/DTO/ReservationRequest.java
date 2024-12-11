package pl.pollub.camp.Models.DTO;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter@Setter
public class ReservationRequest {
    int vehicleId;
    Date reservationStartDate;
    Date reservationEndDate;
    String Location;
    String comments;
}
