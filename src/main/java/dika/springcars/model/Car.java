package dika.springcars;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

    private String model;
    private String color;
    private int maxSpeed;

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

}
