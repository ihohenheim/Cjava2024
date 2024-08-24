/*
-----------------------------------------------------
>>>> Maestría en Electronica  - Enfasis a TIC
>>>> Fundamentos de Programación
>>>> Clase 3 - Ejercitario 1 en JAVA
>>>> Alumno: Daniel Iturry A.
-----------------------------------------------------
*/
/* Imprimir los números enteros 1 al 100 pero n números por línea,
donde n se lee al principio.. */

import java.util.Scanner;

public class ImpNum {
    public static int[][] Sec100 ( int a){
        int nFilas = (int) Math.ceil(100.0/a);  /*Aca hacemos el calculo de la dimencion de la matriz*/
        int k=1;
        
        int[][] Sec100 = new int[nFilas][a];  /*Aca creamos la matriz de la secuencia variable */
        
        /*Rellenamos la matriz*/
        for (int i= 0; i < nFilas; i++){
            for (int j = 0; j < a; j++){
                if (k<=100){ 
                    Sec100[i][j]= k;
                    k++;
                    } else  {
                        Sec100[i][j]= 0;
                    }
                }
                
            }
        // Retorno de la matriz para imprimir en el Main
        return Sec100;
        }
    public static void main (String [] args){
        Scanner scanner = new Scanner (System.in);
        System.out.println("Por favor ingrese el numero de numeros por fila de la secuencia  1 al  100 que desea imprimir: ");
        int n = scanner.nextInt();
        int [][] matriz = Sec100(n); //aca creamos la Matriz segun el numero que ingresamos!! 

        // ahora vamos a imprimir esta matriz
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " \t");
            }
            System.out.println("|");
        }
        System.out.println();
        scanner.close();
    }
}

