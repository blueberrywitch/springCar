package dika.springcars.random;

import java.util.concurrent.ThreadLocalRandom;

public class GetRandom {
    public static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
