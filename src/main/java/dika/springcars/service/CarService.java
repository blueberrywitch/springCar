package dika.springcars.service;

import dika.springcars.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void add(Car car);

    List<Car> listCars();

    Optional<Car> findByModel(String model);
}
