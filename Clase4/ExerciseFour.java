package Clase4;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ExerciseFour {
    public static void main(String[] args) {

        String filePath = args[0];
        String operation = args[1];

        int result;
        if (operation.equals("suma")) {
            result = sumNumbersInFile(filePath);
        } else if (operation.equals("multiplicacion")) {
            result = multiplyNumbersInFile(filePath);
        } else {
            System.out.println("Operación inválida. Debe ser 'suma' o 'multiplicacion'.");
            return;
        }

        System.out.println("El resultado de la operación de " + operation + " de los números en el archivo es " + result + ".");
    }

    public static int sumNumbersInFile(String filePath) {
        int sum = 0;
        String file = filePath;
        for (String line : Files.readAllLines(Paths.get(file))) {
            int num = Integer.parseInt(line.trim());
            sum += num;
        }
        return sum;
    }

    public static int multiplyNumbersInFile(String filePath) {
        int mul = 1;
        String file = filePath;
        for (String line : Files.readAllLines(Paths.get(file))) {
            int num = Integer.parseInt(line.trim());
            mul += num;
        }
        return mul;
    }
}

