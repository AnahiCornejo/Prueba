package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer la cantidad de números
        System.out.print("Ingrese la cantidad de números (N): ");
        int N = scanner.nextInt();
        
        // Variables para acumular
        double SUMPOS = 0;  // Suma de positivos
        double CUPOS = 0;   // Cantidad de positivos
        double SUPMIOS = 0; // Suma de todos
        
        // Procesar cada número
        for (int i = 1; i <= N; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            double NUM = scanner.nextDouble();
            
            // Sumar a todos los números
            SUPMIOS = SUPMIOS + NUM;
            
            // Si es positivo, sumar y contar
            if (NUM > 0) {
                SUMPOS = SUMPOS + NUM;
                CUPOS = CUPOS + 1;
            }
        }
        
        // Calcular promedios
        double PROPOS = 0;
        if (CUPOS > 0) {
            PROPOS = SUMPOS / CUPOS;
        }
        
        double PROALL = SUPMIOS / N;
        
        // Imprimir resultados
        System.out.println("Cantidad de números: " + N);
        System.out.println("Cantidad de positivos: " + CUPOS);
        System.out.println("Promedio de positivos: " + PROPOS);
        System.out.println("Promedio de todos: " + PROALL);
        
        scanner.close();
    }
}
