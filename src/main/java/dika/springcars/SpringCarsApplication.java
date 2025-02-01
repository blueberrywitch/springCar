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
        GetUsers getUser = context.getBean(GetUsers.class);
        int[] salaries = getUser.getUsers();
        for (int salary : salaries) {
            userService.add(new User(salary, CreatRandomCar.creationCar()));
        }

    }

}
