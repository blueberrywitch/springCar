package dika.springcars.service;

import dika.springcars.model.Car;

import java.util.List;

public interface CarService {
    void add(Car car);

    List<Car> listCars();

    Car findByModel(String model);
}
