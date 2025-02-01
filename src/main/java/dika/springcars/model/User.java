package dika.springcars.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @NonNull
    private Car car;

    public User(Long id, int salary, Car car) {
        this.id = id;
        this.salary = salary;
        this.car = car;
    }
}
