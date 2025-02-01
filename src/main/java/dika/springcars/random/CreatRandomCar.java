package dika.springcars.random;

import dika.springcars.enums.Colors;
import dika.springcars.enums.Model;
import dika.springcars.model.Car;

public class CreatRandomCar {
    public static Car creationCar(){
        int numberOfColors = GetRandom.getRandomNumber(0, Colors.values().length);
        int numberOfModel = GetRandom.getRandomNumber(0, Model.values().length);
        return new Car(EnumByIndex.getEnumByIndex(Model.class, numberOfModel).toString(),
                EnumByIndex.getEnumByIndex(Colors.class, numberOfColors),
                GetRandom.getRandomNumber(120, 230),
                GetRandom.getRandomNumber(50000, 9000000));
    }
}
