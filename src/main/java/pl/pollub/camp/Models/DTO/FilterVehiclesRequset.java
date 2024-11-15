package pl.pollub.camp.Models.DTO;

import lombok.Getter;
import pl.pollub.camp.Models.VehicleType;

import java.sql.Date;
@Getter
public class FilterVehiclesRequset {
    Date begining;
    Date end;
}
