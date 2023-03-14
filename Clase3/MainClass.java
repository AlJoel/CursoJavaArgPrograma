package Clase3;
import static Clase3.ClassExerciseOne.*;
import static Clase3.ClassExerciseTwo.*;
public class MainClass {
    public static void main(String[] args) {
        System.out.println(countLetter("Testing", 't'));

        int[] numbers = {1,2,3,4,5};
        System.out.println(sumNumbersGreaterThanX(numbers, 2));

        int[] orderedNumbers = orderNumbers(4,5,2,"asc");
        for(int number: orderedNumbers) {
            System.out.println(number);
        }

        String encoded = encrypt("Testing", 2);
        System.out.println(encoded);
        System.out.println(decrypt(encoded, 2));
    }
}
