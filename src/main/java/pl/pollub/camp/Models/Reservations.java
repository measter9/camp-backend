package pl.pollub.camp.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

enum ReservationType {
    ORDER
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
    @Setter
    @OneToOne
    private Orders Order;
    @Setter
    @ManyToOne
    private Vehicles vehicle;

}
