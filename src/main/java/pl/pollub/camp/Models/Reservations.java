package pl.pollub.camp.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
public class Reservations {
    @Id
    @GeneratedValue
    private int Id;
    @Setter
    private Date start;
    @Setter
    private Date end;
    @Setter
    private String Location;
    @Setter
    @OneToOne
    private Orders Order;
    @Setter
    @ManyToOne
    private Vehicles vehicle;

}
