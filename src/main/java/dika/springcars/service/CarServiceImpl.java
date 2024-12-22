package dika.springcars.service;

import dika.springcars.config.SortConfig;
import dika.springcars.model.Car;
import dika.springcars.reposirotry.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {


    @Autowired
    SortConfig sortConfig;

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
    public Optional<Car> findByModel(String model) {
        return carRepository.findByModel(model);
    }

}
