package dika.springcars.service;

import dika.springcars.model.Car;
import dika.springcars.reposirotry.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> listCars() {
        return carRepository.findAll();
    }

    @Override
    public Car findByModel(String model) {
        return carRepository.findByModel(model);
    }

}
