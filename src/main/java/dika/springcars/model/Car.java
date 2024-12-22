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

    private String model;
    @Enumerated(EnumType.STRING)
    private Colors color;
    private int maxSpeed;

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    public Car() {
    }

    public Car(String model, Colors color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Colors getColor() {
        return color;
    }
}
