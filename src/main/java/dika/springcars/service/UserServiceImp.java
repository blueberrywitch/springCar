package dika.springcars.service;

import dika.springcars.exception.UserNotFoundException;
import dika.springcars.model.Car;
import dika.springcars.model.User;
import dika.springcars.reposirotry.UserRepository;
import dika.springcars.starter.GetUsersFromAPI;
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
    @Value("${loan.minSalary}")
    private int minSalary;
    @Value("${loan.minCarPrice}")
    private int minCarPrice;
    private final UserRepository userRepository;
    private final GetUsersFromAPI getUser;

    @Autowired
    public UserServiceImp(UserRepository userRepository, GetUsersFromAPI getUser) {
        this.userRepository = userRepository;
        this.getUser = getUser;
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("User not found with id: " + userId));
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
    public BigDecimal getLoanSum(Long id) throws UserNotFoundException {
        User user = getUserById(id);
        int salary = getUser.getUsers(id);
        if (loanApproval(user, salary)) {
            return calculateLoan(user, salary);
        }
        return BigDecimal.ZERO;
    }

    private boolean loanApproval(User user, int salary) {
        return salary >= minSalary ||
                user.getCar().getPrice() >= minCarPrice;
    }

    private BigDecimal calculateLoan(User user, int salary) {
        BigDecimal salaryLoan = BigDecimal.valueOf(salary).multiply(MONTH);
        BigDecimal carLoan = BigDecimal.valueOf(user.getCar().getPrice()).multiply(COEFF);
        return salaryLoan.max(carLoan);
    }
}
