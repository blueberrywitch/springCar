package dika.springcars.model;

import dika.springcars.enums.Colors;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    private String model;
    @Enumerated(EnumType.STRING)
    private Colors color;
    private int maxSpeed;

    public Car() {
    }

    public Car(String model, Colors color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
