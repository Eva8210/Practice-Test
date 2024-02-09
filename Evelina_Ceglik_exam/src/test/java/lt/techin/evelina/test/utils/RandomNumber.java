package lt.techin.evelina.test.utils;

public class RandomNumber {
    public static int getRandomNumberForQuantity() {
        int min = 1;
        int max = 20;
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }
}
