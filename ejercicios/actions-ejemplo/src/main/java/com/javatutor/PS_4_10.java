package com.javatutor;

import java.util.Scanner;
import java.util.Arrays;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer la cantidad de elementos
        System.out.print("Ingrese N (cantidad de elementos, max 100): ");
        int N = scanner.nextInt();
        
        // Declarar el arreglo ordenado
        int[] ARRE = new int[100];
        int CANTIDAD = 0;
        
        // Leer los elementos del arreglo
        System.out.println("Ingrese los " + N + " elementos (deben estar ordenados):");
        for (int i = 0; i < N; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            ARRE[i] = scanner.nextInt();
            CANTIDAD++;
        }
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Mostrar arreglo");
            System.out.println("2. Insertar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    // Mostrar arreglo
                    System.out.println("Arreglo actual:");
                    for (int i = 0; i < CANTIDAD; i++) {
                        System.out.print(ARRE[i]);
                        if (i < CANTIDAD - 1) System.out.print(", ");
                    }
                    System.out.println();
                    break;
                    
                case 2:
                    // Insertar elemento
                    if (CANTIDAD >= 100) {
                        System.out.println("Arreglo lleno, no se puede insertar");
                    } else {
                        System.out.print("Ingrese el elemento a insertar: ");
                        int ELEMENTO = scanner.nextInt();
                        
                        // Encontrar posición correcta
                        int POS = 0;
                        while (POS < CANTIDAD && ARRE[POS] < ELEMENTO) {
                            POS++;
                        }
                        
                        // Desplazar elementos
                        for (int i = CANTIDAD; i > POS; i--) {
                            ARRE[i] = ARRE[i - 1];
                        }
                        
                        // Insertar elemento
                        ARRE[POS] = ELEMENTO;
                        CANTIDAD++;
                        System.out.println("Elemento insertado en posición " + (POS + 1));
                    }
                    break;
                    
                case 3:
                    // Eliminar elemento
                    System.out.print("Ingrese el elemento a eliminar: ");
                    int ELEMENTO_ELIM = scanner.nextInt();
                    
                    int POS_ELIM = -1;
                    for (int i = 0; i < CANTIDAD; i++) {
                        if (ARRE[i] == ELEMENTO_ELIM) {
                            POS_ELIM = i;
                            break;
                        }
                    }
                    
                    if (POS_ELIM == -1) {
                        System.out.println("Elemento no encontrado");
                    } else {
                        // Desplazar elementos hacia atrás
                        for (int i = POS_ELIM; i < CANTIDAD - 1; i++) {
                            ARRE[i] = ARRE[i + 1];
                        }
                        CANTIDAD--;
                        System.out.println("Elemento eliminado");
                    }
                    break;
                    
                case 4:
                    continuar = false;
                    System.out.println("Fin del programa");
                    break;
                    
                default:
                    System.out.println("Opción inválida");
            }
        }
        
        scanner.close();
    }
}
