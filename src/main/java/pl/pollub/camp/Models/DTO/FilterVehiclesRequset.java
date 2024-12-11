package pl.pollub.camp.Models.DTO;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter@Setter
public class FilterVehiclesRequset{
    Date begining;
    Date end;
}
