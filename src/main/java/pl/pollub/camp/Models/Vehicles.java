package pl.pollub.camp.Models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

enum VehicleStatus{
    AVAILABLE,
    RENTED,
    UNAVAILABLE,
    SERVICE
}

@Entity
@Getter
public class Vehicles {
    @Id
    @GeneratedValue
    private int Id;
    @Getter
    private String name;
    @Getter
    private String Description;
    @Getter
    private String Comment;
    @OneToOne
    private VehicleType vehicleTypeList;
    @OneToMany
    List<Services> servicesList;
    @OneToMany
    List<Inspections> inspectionsList;


}
