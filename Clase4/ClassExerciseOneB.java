package Clase4;

import java.util.Scanner;

import static Clase3.ClassExerciseOne.orderNumbers;

public class ClassExerciseOneB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Ingrese el tercer número: ");
        int num3 = scanner.nextInt();

        System.out.print("Ingrese 'asc' para ordenar de forma ascendente o 'desc' para ordenar de forma descendente: ");
        String order = scanner.next();

        int[] orderedNumbers = orderNumbers(num1, num2, num3, order);

        System.out.println("Los números ordenados " + order + " son:");
        for (int num : orderedNumbers) {
            System.out.println(num);
        }
    }
}
