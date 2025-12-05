package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer la cantidad de elementos
        System.out.print("Ingrese N (cantidad de elementos, max 50): ");
        int N = scanner.nextInt();
        
        // Declarar el arreglo
        int[] UNI = new int[N];
        
        // Leer los elementos del arreglo
        for (int i = 0; i < N; i++) {
            System.out.print("Ingrese elemento " + (i + 1) + ": ");
            UNI[i] = scanner.nextInt();
        }
        
        // Ordenar usando selección directa
        for (int i = 0; i < N - 1; i++) {
            int MENOR = i;
            
            // Encontrar el índice del elemento menor
            for (int j = i + 1; j < N; j++) {
                if (UNI[j] < UNI[MENOR]) {
                    MENOR = j;
                }
            }
            
            // Intercambiar elementos
            int TEMP = UNI[i];
            UNI[i] = UNI[MENOR];
            UNI[MENOR] = TEMP;
        }
        
        // Mostrar el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int i = 0; i < N; i++) {
            System.out.print(UNI[i]);
            if (i < N - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        
        scanner.close();
    }
}
