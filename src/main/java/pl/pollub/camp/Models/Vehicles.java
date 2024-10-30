package pl.pollub.camp.Models;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;

import java.util.List;

@Entity
@Getter
public class Vehicles {
    @Id
    @GeneratedValue
    @Setter
    private int Id;
    @Getter
    @Setter
    private String name;
    @Getter
    private String Description;
    @Getter

    @Setter
    private VehicleStatus vehicleStatus;
    @Getter
    @Setter
    private String Comment;
    @OneToOne
    @Setter
    private VehicleType vehicleTypeList;
    @OneToMany
    List<Services> servicesList;
    @OneToMany
    List<Inspections> inspectionsList;


}
