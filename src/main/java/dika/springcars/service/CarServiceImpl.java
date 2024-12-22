package dika.springcars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDaoImpl implements CarDao {

    @Autowired
    private CarRepository carRepository;

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
