package dika.springcars.model;

import dika.springcars.enums.Colors;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @Enumerated(EnumType.STRING)
    private Colors color;

    private int maxSpeed;

    private int price;

    public Car(String model, Colors color, int maxSpeed, int price) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }
}
