package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

enum OrderStatus{
    CANCELED,
    PAID,
    PENDING,
    FINISHED,
    OTHER
}
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


}
