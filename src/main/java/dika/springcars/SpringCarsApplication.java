package dika.springcars;

import dika.springcars.model.User;
import dika.springcars.random.CreatRandomCar;
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
        userService.add(new User("John", CreatRandomCar.creationCar()));
        userService.add(new User("Mike", CreatRandomCar.creationCar()));
        userService.add(new User("Tom", CreatRandomCar.creationCar()));
        userService.add(new User("Alice", CreatRandomCar.creationCar()));
        userService.add(new User("Bob", CreatRandomCar.creationCar()));
        userService.add(new User("Kate", CreatRandomCar.creationCar()));
        userService.add(new User("Liza", CreatRandomCar.creationCar()));

        GetUsers getUsers = context.getBean(GetUsers.class);
        System.out.println(getUsers.getUsers(1L));
    }

}
