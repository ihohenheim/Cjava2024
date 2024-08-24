/*
-----------------------------------------------------
>>>> Maestría en Electronica  - Enfasis a TIC
>>>> Fundamentos de Programación
>>>> Clase 4 - Ejercitario 3 en JAVA
>>>> Alumno: Daniel Iturry A.
-----------------------------------------------------
*/
/* Desarrolle un programa para jugar un juego sencillo de lotería. El programa debe generar
en forma aleatoria un número entero de seis dígitos (NL), solicitar al usuario un número
entero de seis dígitos (NU) e imprimir el monto de premio que el usuario ganó de acuerdo
con las siguientes reglas: */
/*  Caso                            | Premio        | Jemplo
 *  NL = NU                         | 500 000       | NL = 123456 && NU = 123456 -> Todos coninciden en orden y dígito
 *  SI NU contiene 6 dig de NL      | 150 000       | NL = 123456 && NU = 654321 -> Coinciden en dígito pero no en orden
 *  SI NU contiene 5 dig de NL      | 100 000       | NL = 123456 && NU = 123458 -> Coinciden 5 dígitos pero no en orden
 *  SI NU contiene 3 dig de NL      | 10 000        | NL = 123456 && NU = 172389 -> Coinciden 3 dígitos pero no en orden
 */

/*Obs: se debe de verificar que el numero leido debe de ser de  6 digitos, si no es asi, solicitar de nuevo.
 * En caso de que ingrese un número negativo o 0, saldra del programa.
 * Para el cierre del programa se debe de imprimir en pantalla lo ganado, o entregado.
 * Se agrega que el programa cierra cuando, tambien se ha tenido un premio, o se ha superado  3 intentos, aparte del 0 y numero negativo 
 */

import java.util.Random;
import java.util.Scanner;

public class Loteria{
/*Con esta funcion tenemos el numero random de loteria */
    public static int[] NL() {
        Random random = new Random();
        int numeroGanador = 100000 + random.nextInt(900000);
        return convertirNumeroAArray (numeroGanador);
    }

    public static int[] convertirNumeroAArray(int numero) {
        int[] array = new int[6];
        for (int i = 5; i >= 0; i--) {
            array[i] = numero % 10;
            numero /= 10;
        }
        return array;
    }   
/*Con esta funcion tendremos el analisis de los premios segun la tabla devolviendo un valor bandera por cada tipo de coincidencia */
    public static int AnlPrem (int[] a, int[] b){
        int ban =0; int Prem =0; 
        boolean iguales = true;
        for (int i=0; i<6; i++){
            if (a[i] != b[i]){
                iguales = false;
                break;
            }
        }
        if (iguales){
            return 1;
        }
                
        for (int i=0; i<6; i++) {
            for (int j=0; j<6; j++){
                if (a[i] == b[j]){
                    ban++;
                    break;
                    }
                }
            }
        switch (ban){
            case 6:
                Prem = 2;
                break;
            case 5:
                Prem = 3;
                break;
            case 3:
                Prem = 4;
                break;   
            default:
                Prem = 0;
                break; 
        }
        return Prem;
   }
/*Iniciamos el programa */

    public static void main (String[] args){
    Scanner scanner = new Scanner(System.in);
    int[] NL = NL();
    
    /*Pediremos que ingrese el número de  6 digitos, esto lo haremos por digito no por bloque*/
    int[] NU = new int[6]; 
    System.out.println ("Por favor ingrese cualquier número si desea participar o 0 si desea salir del programa");
    int onoff = scanner.nextInt();
    int PremAcum = 0;
    while (onoff > 0){ 
    for (int i = 0; i < 6; i++){
        boolean valido = false;
        while (!valido) {
            System.out.print ("Ingrese el número " + (i+1) + " de sus 6 numeros de loteria: ");
            NU[i] = scanner.nextInt();
            if  (i == 0 && (NU[i] <=0)) {
                System.out.println ("El primer dígito ingresado debe de ser  >0, no se aceptan valores negativos");
        } else if (NU[i]< 0){
            System.out.println ("No se permiten numeros negativos, vuelva a ingresar su número");
        } else {
            valido = true;
            }
        }
    }
    System.out.println();
    System.out.print("El número ingresado es: \n | ");
    for (int i = 0; i < 6; i++) {
        System.out.print(NU[i] + " | ");
    }
    System.out.println();

    System.out.print("El número ganador es: \n | ");
    for (int i = 0; i < 6; i++) {
        System.out.print(NL[i] + " | ");
    }
    System.out.println();

/*Con las funciones hechas vamos a analizar y mostrar el premio */
    int premio = AnlPrem(NU, NL); int PremGan =0;
    switch (premio){
        case 1:
            System.out.println("Has ganado el Premio Gordo!! Gs 500 000 ");
            PremGan = 500000;
            break;
        case 2:
            System.out.println("Has ganado el Segundo premio!! Gs 150 000 ");
            PremGan = 150000;
            break;
        case 3:
            System.out.println("Has ganado el Tercer premio!! Gs 100 000 "); 
            PremGan = 100000;   
            break;    
        case 4:
            System.out.println("Has ganado el Cuarto premio!! Gs 10 000 ");  
            PremGan = 10000;  
            break;
        default:
            System.out.println("No has ganado ni un premio (X_X)");   
            PremGan = 0; 
            break;
    }
    PremAcum += PremGan;
    System.out.println ("Llevas acumulado: Gs" +PremAcum);
    System.out.println ("Quieres probar otro número, digita 1 si SI!! o 0 si desea salir del programa");
    onoff = scanner.nextInt();
} 
    System.out.println("Gracias por participar!!!! ");
    
    scanner.close();
}
}