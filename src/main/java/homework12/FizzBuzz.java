package homework12;

public class FizzBuzz {
    public static boolean fizz(int number){
        if (number % 3 == 0 & number % 5 != 0) {
            return true;
        }
        return false;
    }

    public static boolean buzz(int number){
        if (number % 5 == 0 & number % 3 != 0) {
            return true;
        }
        return false;
    }

    public static boolean fizzbuzz(int number){
        if (number % 15 == 0) {
            return true;
        }
        return false;
    }
}
