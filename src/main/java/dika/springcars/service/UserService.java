package dika.springcars.service;

import dika.springcars.exception.MyException;
import dika.springcars.model.Car;
import dika.springcars.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    Optional<User> findByCar(Car car);

    User getUserById(Long userId) throws MyException;

    BigDecimal getLoanSum(Long id) throws MyException;
}
