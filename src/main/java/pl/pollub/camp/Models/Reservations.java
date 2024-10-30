package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

enum ReservationType{

}
@Entity
@Getter
public class Reservations {
    @Id
    @GeneratedValue
    private int Id;
    @Setter
    private Date Start;
    @Setter
    private Date End;
    @Setter
    private String Location;
    @OneToOne
    private Orders Order;
    @ManyToOne
    private Vehicles Vehicle;
}
