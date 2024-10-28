package pl.pollub.camp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@RequiredArgsConstructor
public class Users {
    @Id
    @GeneratedValue
    private Integer id;
    @Setter @NonNull
    private String name;
    @Setter @NonNull
    private String email;
    @Setter @NonNull
    private String password;
    @Setter @Getter
    private Role role;
    @Setter
    @OneToMany
    List<Orders> ordersList;

    public Users(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.email = users.getEmail();
        this.password = users.getPassword();
        this.role = users.getRole();
        this.ordersList = users.getOrdersList();
    }

    public Users() {
    }
}
