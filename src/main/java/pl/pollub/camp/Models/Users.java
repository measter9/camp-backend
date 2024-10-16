package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer id;
    @Setter
    private String name;
    @Setter
    private String email;
    @Setter
    private String password;

}
