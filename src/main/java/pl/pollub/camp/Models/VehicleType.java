package pl.pollub.camp.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
public class VehicleType {
    @Id
    @GeneratedValue
    private int Id;
    @Setter
    private String Description;
    @Setter
    private String Name;
    @Setter
    @OneToMany
    List <Vehicles> vehiclesList;

}
