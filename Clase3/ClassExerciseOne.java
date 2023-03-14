package Clase3;

import java.util.Arrays;

public class ClassExerciseOne {
    public static int countLetter(String str, char letter) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    public static int[] orderNumbers(int num1, int num2, int num3, String order) {
        int[] numbers = {num1, num2, num3};
        if (order.equals("asc")) {
            Arrays.sort(numbers);
        } else if (order.equals("desc")) {
            Arrays.sort(numbers);
            int temp = numbers[0];
            numbers[0] = numbers[2];
            numbers[2] = temp;
        }
        return numbers;
    }

    public static int sumNumbersGreaterThanX(int[] numbers, int x) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > x) {
                sum += numbers[i];
            }
        }
        return sum;
    }


}


