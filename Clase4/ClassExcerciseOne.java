package Clase4;
import java.util.Scanner;

import static Clase3.ClassExerciseOne.*;
import static Clase3.ClassExerciseTwo.*;

public class ClassExcerciseOne {
    public static void main(String[] args) {

        if (args.length < 4) {
            System.out.println("Debe proporcionar tres números y una cadena 'a' (ascendente) o 'd'(descendente).");
            return;
        }

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        String order = args[3] == "a" ? "asc" : "desc";

        int[] orderedNumbers = orderNumbers(num1, num2, num3, order);

        System.out.println("Los números ordenados " + order + " son:");
        for (int num : orderedNumbers) {
            System.out.println(num);
        }
    }


}
