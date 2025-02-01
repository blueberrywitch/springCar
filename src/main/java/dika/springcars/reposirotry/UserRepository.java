package dika.springcars.reposirotry;

import dika.springcars.model.Car;
import dika.springcars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByCar(Car car);
}
