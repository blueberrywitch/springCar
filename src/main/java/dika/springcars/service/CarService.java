package dika.springcars;

import java.util.List;

public interface CarDao {
    void add(Car car);

    List<Car> listCars();

    Car findByModel(String model);
}
