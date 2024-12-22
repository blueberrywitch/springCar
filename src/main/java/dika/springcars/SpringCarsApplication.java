package dika.springcars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCarsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringCarsApplication.class, args);
//        CarService carService = context.getBean(CarService.class);
//        carService.add(new Car("Mercedes", Colors.BLACK, 100));
//        carService.add(new Car("BMW", Colors.GRAY,120));
//        carService.add(new Car("Audi", Colors.RED,200));
//        carService.add(new Car("Toyta", Colors.PINK,99));
    }
}
