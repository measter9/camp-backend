package pl.pollub.camp.Models.DTO;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import pl.pollub.camp.Models.*;

@Getter@Setter
public class VehicleRequest{
        private int Id;
        private String name;
        private String Description;
        private VehicleStatus vehicleStatus;
        private String Comment;
        @OneToOne
        private VehicleType vehicleType;

}
