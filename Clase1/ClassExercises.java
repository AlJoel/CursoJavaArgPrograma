/*
package Clase1;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ClassExercises {
    String name = "Joel";
    public void salute(String name) {
        System.out.println("Bienvenido "+ name);
    }


    public void lecturaNombre(){
        // Utilizando scanner:
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, ingrese su nombre: ");
        String name = sc.nextLine();

        // Utilizando JOptionPane:
        name = JOptionPane.showInputDialog("Por favor, ingrese su nombre:");

        System.out.println("Bienvenido " + name);
    }
}
    public void matema(){
        int num1 = 10;
        int num2 = 3;

        // Mostrar la suma de num1 y num2
        int suma = num1 + num2;
        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + suma);

        // Mostrar la resta de num1 y num2
        int resta = num1 - num2;
        System.out.println("La resta de " + num1 + " y " + num2 + " es: " + resta);

        // Mostrar la multiplicación de num1 y num2
        int multiplicacion = num1 * num2;
        System.out.println("La multiplicación de " + num1 + " y " + num2 + " es: " + multiplicacion);

        // Mostrar la división de num1 y num2
        double division = (double) num1 / num2;
        System.out.println("La división de " + num1 + " y " + num2 + " es: " + division);

        // Mostrar el módulo de num1 y num2
        int modulo = num1 % num2;
        System.out.println("El módulo de " + num1 + " y " + num2 + " es: " + modulo);
    }
}
    public class NumeroMayor{
        int numero1 = 10;
        int numero2 = 5;

        if (numero1 > numero2) {
            System.out.println(numero1 + " es mayor que " + numero2);
        } else if (numero2 > numero1) {
                System.out.println(numero2 + " es mayor que " + numero1);
        } else {
            System.out.println(numero1 + " y " + numero2 + " son iguales");
        }
    }
    public class DivisiblePor2 {

        public static void main(String[] args) {

            // Pedir al usuario que ingrese un número
            Scanner sc = new Scanner(System.in);
            System.out.print("Por favor, ingrese un número: ");
            int numero = sc.nextInt();

            // Verificar si el número es divisible por 2
            if (numero % 2 == 0) {
                System.out.println(numero + " es divisible por 2");
            } else {
                System.out.println(numero + " no es divisible por 2");
            }
        }

    }

    public class PrecioConIva {

        public static void main(String[] args) {

            // Definir la constante del IVA
            double IVA = 0.21;

            // Pedir al usuario que ingrese el precio del producto
            Scanner sc = new Scanner(System.in);
            System.out.print("Por favor, ingrese el precio del producto: ");
            double precio = sc.nextDouble();

            // Calcular el precio final con IVA
            double precioFinal = precio * (1 + IVA);

            // Mostrar el precio final con IVA
            System.out.println("El precio final con IVA es: " + precioFinal);
        }

    }

    public class NumerosDelUnoAlCien {

        public static void main(String[] args) {

            // Inicializar la variable del contador
            int contador = 1;

            // Imprimir los números del 1 al 100 con un bucle while
            while (contador <= 100) {
                System.out.println(contador);
                contador++;
            }
        }

    }

    public class NumerosDelUnoAlCien {

        public static void main(String[] args) {

            // Imprimir los números del 1 al 100 con un bucle for
            for (int i = 1; i <= 100; i++) {
                System.out.println(i);
            }
        }

    }

    public class NumerosDivisibles {

        public static void main(String[] args) {

            // Inicializar la variable del contador
            int contador = 1;

            // Imprimir los números del 1 al 100 divisibles entre 2 y 3 con un bucle while
            while (contador <= 100) {
                if (contador % 2 == 0 && contador % 3 == 0) {
                    System.out.println(contador);
                }
                contador++;
            }
        }

    }

    public class NumeroMayorOIgualACero {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int numero;

            do {
                System.out.print("Introduce un número mayor o igual que cero: ");
                numero = scanner.nextInt();
            } while (numero < 0);

            System.out.println("El número introducido es: " + numero);
        }

    }

    public class VerificacionDeContrasena {

        public static void main(String[] args) {

            // Establecer la contraseña
            String contrasena = "infalible123";

            Scanner scanner = new Scanner(System.in);
            int intentos = 3;
            boolean accesoCorrecto = false;

            do {
                System.out.print("Introduce la contraseña: ");
                String entrada = scanner.nextLine();
                if (entrada.equals(contrasena)) {
                    accesoCorrecto = true;
                    break;
                } else {
                    intentos--;
                    System.out.println("Contraseña incorrecta. Te quedan " + intentos + " intentos.");
                }
            } while (intentos > 0);

            if (accesoCorrecto) {
                System.out.println("Acceso Correcto");
            } else {
                System.out.println("No tienes más intentos. Acceso Denegado");
            }
        }

    }

    public class DiaLaboral {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int diaSemana;

            do {
                System.out.print("Introduce un día de la semana (1-7): ");
                diaSemana = scanner.nextInt();
            } while (diaSemana < 1 || diaSemana > 7);

            switch (diaSemana) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("El día " + diaSemana + " es laboral");
                    break;
                case 6:
                case 7:
                    System.out.println("El día " + diaSemana + " no es laboral");
                    break;
            }
        }

    }

    public class NumeroPrimo {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce un número: ");
            int num = scanner.nextInt();
            boolean esPrimo = true;

            if (num <= 1) {
                esPrimo = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        esPrimo = false;
                        break;
                    }
                }
            }

            if (esPrimo) {
                System.out.println(num + " es un número primo");
            } else {
                System.out.println(num + " no es un número primo");
            }

        }

    }

    public class AdivinaNumero {
        public static void main(String[] args) {
            double newDouble = Math.random() * 100;
            int numAleatorio = (int) newDouble;
            int intentos = 0;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Adivina el número entre 0 y 100: ");

            while (true) {
                int numIngresado = scanner.nextInt();
                intentos++;

                if (numIngresado == numAleatorio) {
                    System.out.println("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
                    break;
                } else if (numIngresado < numAleatorio) {
                    System.out.println("El número ingresado es menor. Intenta de nuevo.");
                } else {
                    System.out.println("El número ingresado es mayor. Intenta de nuevo.");
                }
            }
        }
    }

*/
