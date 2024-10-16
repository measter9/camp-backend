package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @Setter @Getter
    private Role role;
    @Setter
    @OneToMany
    List<Orders> ordersList;
}
