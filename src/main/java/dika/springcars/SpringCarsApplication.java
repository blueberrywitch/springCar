package dika.springcars;

import dika.springcars.model.User;
import dika.springcars.random.CreateRandomCar;
import dika.springcars.service.UserServiceImp;
import dika.springcars.starter.GetUsers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"dika.springcars", "dika.springbootstarter"})
public class SpringCarsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringCarsApplication.class, args);

        UserServiceImp userService = context.getBean(UserServiceImp.class);
        userService.add(new User("John", CreateRandomCar.creationCar()));
        userService.add(new User("Mike", CreateRandomCar.creationCar()));
        userService.add(new User("Tom", CreateRandomCar.creationCar()));
        userService.add(new User("Alice", CreateRandomCar.creationCar()));
        userService.add(new User("Bob", CreateRandomCar.creationCar()));
        userService.add(new User("Kate", CreateRandomCar.creationCar()));
        userService.add(new User("Liza", CreateRandomCar.creationCar()));

        GetUsers getUsers = context.getBean(GetUsers.class);
        System.out.println(getUsers.getUsers(1L));
    }

}
