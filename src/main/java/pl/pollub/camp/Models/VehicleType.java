package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

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
    @OneToOne
    private Vehicles vehicle;

}
