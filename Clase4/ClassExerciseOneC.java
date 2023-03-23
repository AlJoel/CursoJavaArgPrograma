package Clase4;

import java.util.Scanner;

import static Clase3.ClassExerciseOne.*;

public class ClassExerciseOneC {
    public static void main(String[] args) {
        int num1, num2, num3;
        String order;

        if (args.length == 4) {
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[1]);
            num3 = Integer.parseInt(args[2]);
            order = args[3];
        } else {
            Scanner scanner = new Scanner(System.in);
            num1 = readIntFromConsole(scanner, "Ingrese el primer número: ");
            num2 = readIntFromConsole(scanner, "Ingrese el segundo número: ");
            num3 = readIntFromConsole(scanner, "Ingrese el tercer número: ");
            order = readOrderFromConsole(scanner);
        }

        int[] orderedNumbers = orderNumbers(num1, num2, num3, order);

        System.out.println("Los números ordenados " + order + " son:");
        for (int num : orderedNumbers) {
            System.out.println(num);
        }
    }
    public static int readIntFromConsole(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public static String readOrderFromConsole(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese 'asc' para ordenar de forma ascendente o 'desc' para ordenar de forma descendente: ");
            String order = scanner.next();
            if (order.equals("asc") || order.equals("desc")) {
                return order;
            }
        }
    }
}
