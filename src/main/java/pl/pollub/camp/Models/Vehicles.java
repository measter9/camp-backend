package pl.pollub.camp.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Vehicles{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String Description;
    private VehicleStatus vehicleStatus;
    private String Comment;
    @OneToOne
    private VehicleType vehicleType;
}
