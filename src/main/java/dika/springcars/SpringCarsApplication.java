package dika.springcars;

import dika.springcars.enums.Colors;
import dika.springcars.enums.Model;
import dika.springcars.model.Car;
import dika.springcars.model.User;
import dika.springcars.random.CreatRandomCar;
import dika.springcars.service.UserServiceImp;
import dika.springcars.random.EnumByIndex;
import dika.springcars.random.GetRandom;
import dika.springcars.starter.GetUsers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"dika.springcars", "dika.springbootstarter"})
public class SpringCarsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringCarsApplication.class, args);

        UserServiceImp userService = context.getBean(UserServiceImp.class);
        GetUsers getUser = context.getBean(GetUsers.class);
        List<User> userList =  getUser.getUsers();
        for (User user : userList){
            userService.add(new User(user.getId(), user.getSalary(), CreatRandomCar.creationCar()));
        }

    }

}
