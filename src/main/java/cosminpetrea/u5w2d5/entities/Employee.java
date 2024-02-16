package cosminpetrea.u5w2d5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue
    private UUID id;
    private String username;
    private String name;
    private String surname;
    private String email;
}
