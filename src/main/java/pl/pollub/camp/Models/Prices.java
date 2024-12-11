package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
public class Prices{
    @Id
    @GeneratedValue
    private int id;
    @Setter
    private Double Price;
    @Setter
    private Date Start;
    @Setter
    private Date End;
}
