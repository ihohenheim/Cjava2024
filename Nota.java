/*
-----------------------------------------------------
>>>> Maestría en Electronica  - Enfasis a TIC
>>>> Fundamentos de Programación
>>>> Clase 3 - Ejercitario 2 en JAVA
>>>> Alumno: Daniel Iturry A.
-----------------------------------------------------
*/
/* Leer un puntaje y el nombre de un alumno. Imprimir el nombre del
alumno y la nota de acuerdo con la escala del ejemplo presentado.
Validar que la nota se encuentre entre 0 y 100, volver a solicitar si no
lo es. */
/*
 * Segun el ejemplo  la escala es:
 * De  000 - 059 -> 1
 * De  060 - 069 -> 2
 * De  070 - 079 -> 3
 * De  080 - 090 -> 4
 * De  091 - 100 -> 5
 */

 import java.util.Scanner;

public class Nota {
    // Funcion para poder determinar la nota segun el puntaje optenido por el alumno
    public static int NotaIN (int a){
        int nota=0;
        // Primero validamos que la nota ingresada sea un valor del 0 al 100
        if (a < 0 || a > 100){
            return nota = 6;  // si el puntaje esta en un valor no aceptable, se retorna 6 como bandera FAIL! al main! 
            //break;
        } else if (a <= 59 ){  // Aca ya estamos en los casos potables de puntaje y discriminamos el puntaje correspondiente! 
            nota = 1;
        } else if (a >= 60 && a <= 69){
            nota = 2;
        } else if (a >= 70 && a <= 79){
            nota = 3;
        } else if (a >= 80 && a <= 90){
            nota = 4;
        } else
            nota = 5; 
        return nota;
    }
    public static void main (String [] args){
        System.out.println("Ingrese por favor el nombre del alumno:");
        Scanner scanner = new Scanner (System.in);
        String NAlum = scanner.nextLine(); // Nombre y apellido  
        int n ;        
        int nota;
        
        do {
            System.out.println("Ahora ingrese su puntaje del 1 al 100 para saber la nota:");
            n = scanner.nextInt();
            nota = NotaIN(n);
            if (nota ==6){
                System.out.println("Puntaje inválido. Por favor ingrese un valor entre 0 y 100.");
            }
        } while (nota == 6);

        System.out.println("La nota de:\n[ " + NAlum + " ] \nes:");
        System.out.print("[  " + nota + "  ]\n");
        scanner.close();
    }
}