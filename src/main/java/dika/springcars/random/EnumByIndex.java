package dika.springcars.random;

public class EnumByIndex {
    public static <T extends Enum<T>> T getEnumByIndex(Class<T> enumClass, int index) {
        return enumClass.getEnumConstants()[index];
    }
}
