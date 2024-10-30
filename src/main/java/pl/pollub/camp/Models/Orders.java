package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Orders {
@Id
    @GeneratedValue
    private int Id;
    @Setter
    private OrderStatus orderStatus;
    @Setter
    private String comment;
    @Setter
    @ManyToOne
    private Users user;
}
