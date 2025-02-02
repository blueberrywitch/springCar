package dika.springcars.random;

import dika.springcars.enums.CarModel;
import dika.springcars.enums.Colors;
import dika.springcars.model.Car;

public class CreateRandomCar {
    public static Car creationCar() {
        int numberOfColors = GetRandom.getRandomNumber(0, Colors.values().length);
        int numberOfModel = GetRandom.getRandomNumber(0, CarModel.values().length);
        return new Car(EnumByIndex.getEnumByIndex(CarModel.class, numberOfModel).toString(),
                EnumByIndex.getEnumByIndex(Colors.class, numberOfColors),
                GetRandom.getRandomNumber(120, 230),
                GetRandom.getRandomNumber(50000, 3000000));
    }
}
