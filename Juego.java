/*
-----------------------------------------------------
>>>> Maestría en Electronica  - Enfasis a TIC
>>>> Fundamentos de Programación
>>>> Clase 3 - Ejercitario 3 en JAVA
>>>> Alumno: Daniel Iturry A.
-----------------------------------------------------
*/
/* Considere el siguiente juego. Generar un número aleatorio A entre 0 y
100. Leer un número N entre 0 y 100. Si el número N es distinto de A
entonces volver a solicitar otro número y repetir el proceso de
comparación. Si el número coincidió terminar el Proceso e imprimir
“Ganó en # intentos”, donde intentos indica el número de veces que
repitió el proceso. El proceso también puede terminarse
introduciendo un número negativo o mayor a 100 y en ese caso
imprimir “No acertaste e hiciste # intentos”. */

import java.util.Random;
import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        // Crear un generador de números aleatorios
        Random random = new Random();
        int A = random.nextInt(101); // Genera un número aleatorio entre 0 y 100

        Scanner scanner = new Scanner(System.in);
        int N = -1; // Inicializamos N, fuera del rango válido
        int intentos = 0; // Contador de intentos

        while (true) {
            System.out.println("Adivina el número (entre 0 y 100) o digita 101 si quieres salir!! ");
            N = scanner.nextInt();
            intentos++;

            // Terminar si el se ingresa un número fuera del rango permitido, criterios de salida...
            if (N < 0 || N > 100) {
                System.out.println("No acertaste en " + intentos + " intentos :( ");
                break;
            }

            // parte de comprobar
            if (N == A) {
                System.out.println("¡Ganaste!!! en " + intentos + " intentos!");
                break;
            } else {
                System.out.println("No es el número correcto. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}
