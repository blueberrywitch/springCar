package dika.springcars.service;

import dika.springcars.model.Car;
import dika.springcars.model.User;
import dika.springcars.reposirotry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImp implements UserService {

    private static final BigDecimal MONTH = BigDecimal.valueOf(6);
    private static final BigDecimal COEFF = BigDecimal.valueOf(0.3);
    private final UserRepository userRepository;
    @Value("${loan.minSalary}")
    private int minSalary;
    @Value("${loan.minCarPrice}")
    private int minCarPrice;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("User not found with id: " + userId));
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByCar(Car car) {
        return userRepository.findByCar(car);
    }

    @Override
    public BigDecimal getLoanSum(Long id) {
        User user = getUserById(id);
        if (loanApproval(user)) {
            return calculateLoan(user);
        }
        return BigDecimal.ZERO;
    }

    private boolean loanApproval(User user) {
        return user.getSalary() >= minSalary ||
                user.getCar().getPrice() >= minCarPrice;
    }

    private BigDecimal calculateLoan(User user) {
        BigDecimal salaryLoan = BigDecimal.valueOf(user.getSalary()).multiply(MONTH);
        BigDecimal carLoan = BigDecimal.valueOf(user.getCar().getPrice()).multiply(COEFF);
        return salaryLoan.max(carLoan);
    }
}
