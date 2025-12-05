package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer la dimensión de la matriz
        System.out.print("Ingrese N (dimensión de matriz N x N, max 30): ");
        int N = scanner.nextInt();
        
        // Declarar la matriz A
        int[][] A = new int[N][N];
        
        // Leer la matriz
        System.out.println("Ingrese los elementos de la matriz A(" + N + "x" + N + "):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = scanner.nextInt();
            }
        }
        
        // Generar arreglo B según las reglas
        double[] B = new double[N];
        
        for (int i = 0; i < N; i++) {
            int resto = i % 4;
            
            if (resto == 0) {
                // Suma de la fila i
                double suma = 0;
                for (int j = 0; j < N; j++) {
                    suma += A[i][j];
                }
                B[i] = suma;
                System.out.println("B[" + i + "] = Suma fila " + i + " = " + B[i]);
                
            } else if (resto == 1) {
                // Suma de la columna i
                double suma = 0;
                for (int j = 0; j < N; j++) {
                    suma += A[j][i];
                }
                B[i] = suma;
                System.out.println("B[" + i + "] = Suma columna " + i + " = " + B[i]);
                
            } else if (resto == 2) {
                // Suma de diagonal principal
                double suma = 0;
                for (int j = 0; j < N; j++) {
                    suma += A[j][j];
                }
                B[i] = suma;
                System.out.println("B[" + i + "] = Suma diagonal principal = " + B[i]);
                
            } else if (resto == 3) {
                // Suma de A[i-2] * diagonal principal
                if (i >= 2) {
                    double suma = 0;
                    for (int j = 0; j < N; j++) {
                        suma += A[i - 2][j] * A[j][j];
                    }
                    B[i] = suma;
                    System.out.println("B[" + i + "] = Suma A[" + (i - 2) + "] * diagonal = " + B[i]);
                } else {
                    B[i] = 0;
                    System.out.println("B[" + i + "] = 0 (índice i-2 inválido)");
                }
            }
        }
        
        // Mostrar el arreglo B
        System.out.println("\nArreglo B resultado:");
        for (int i = 0; i < N; i++) {
            System.out.println("B[" + i + "] = " + B[i]);
        }
        
        scanner.close();
    }
}
