package java1.homework2;

public class HomeWorkApp2 {

    public static void main(String[] args) {

        System.out.println("Sum between 10 and 20: " + sumBetween10and20(10, 9));
        checkPositiveOrNegative(0);
        System.out.println("Is it a negative number?: " + numberIsNegative(-3));
        printPhrase("Simplicity is the ultimate sophistication", 5);
        System.out.println("Is this a leap year?: " + leapYear(12));
    }

    public static boolean sumBetween10and20(int value1, int value2) {
        return ((value1 + value2) >= 10 && (value1 + value2) <= 20);
    }

    public static void checkPositiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println(number + " - is positive");
        } else {
            System.out.println(number + " - is negative");
        }
    }

    public static boolean numberIsNegative(int a) {
        return (a < 0);
    }

    public static void printPhrase(String phrase, int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(i + ": " + phrase);
        }
    }

    public static boolean leapYear(int year) {
        return (year > 0 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0));
    }
}

