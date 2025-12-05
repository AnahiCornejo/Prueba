package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    
    // Clase interna para representar una habitación
    static class Habitacion {
        int NUM;           // Número de habitación
        String TIPO;       // SI=Simple, DO=Doble, TR=Triple, SU=Suite
        double PRECIO;     // Precio de la habitación
        String DISP;       // SI=Disponible, NO=No disponible
        String HUESPED;    // Nombre del huésped
    }
    
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Arreglo de habitaciones (máximo 100)
        Habitacion[] HABI = new Habitacion[100];
        int CANTIDAD = 0;
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n=== SISTEMA DE HOTEL ===");
            System.out.println("1. Agregar habitación");
            System.out.println("2. Listar habitaciones");
            System.out.println("3. Buscar por nombre de huésped");
            System.out.println("4. Buscar disponibles");
            System.out.println("5. Eliminar habitación");
            System.out.println("6. Salir");
            System.out.print("Seleccione opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea
            
            switch (opcion) {
                case 1:
                    // Agregar habitación
                    if (CANTIDAD >= 100) {
                        System.out.println("Hotel lleno");
                    } else {
                        HABI[CANTIDAD] = new Habitacion();
                        
                        System.out.print("Número de habitación: ");
                        HABI[CANTIDAD].NUM = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Tipo (SI/DO/TR/SU): ");
                        HABI[CANTIDAD].TIPO = scanner.nextLine();
                        
                        System.out.print("Precio: ");
                        HABI[CANTIDAD].PRECIO = scanner.nextDouble();
                        scanner.nextLine();
                        
                        System.out.print("Disponible (SI/NO): ");
                        HABI[CANTIDAD].DISP = scanner.nextLine();
                        
                        if (HABI[CANTIDAD].DISP.equals("SI")) {
                            HABI[CANTIDAD].HUESPED = "";
                        } else {
                            System.out.print("Nombre del huésped: ");
                            HABI[CANTIDAD].HUESPED = scanner.nextLine();
                        }
                        
                        CANTIDAD++;
                        System.out.println("Habitación agregada");
                    }
                    break;
                    
                case 2:
                    // Listar todas las habitaciones
                    if (CANTIDAD == 0) {
                        System.out.println("No hay habitaciones");
                    } else {
                        System.out.println("\n=== LISTADO DE HABITACIONES ===");
                        for (int i = 0; i < CANTIDAD; i++) {
                            System.out.println("Habitación #" + HABI[i].NUM + 
                                " | Tipo: " + HABI[i].TIPO + 
                                " | Precio: $" + HABI[i].PRECIO +
                                " | Disponible: " + HABI[i].DISP +
                                " | Huésped: " + HABI[i].HUESPED);
                        }
                    }
                    break;
                    
                case 3:
                    // Buscar por nombre de huésped
                    System.out.print("Ingrese nombre del huésped: ");
                    String NOMBRE = scanner.nextLine();
                    
                    boolean encontrado = false;
                    for (int i = 0; i < CANTIDAD; i++) {
                        if (HABI[i].HUESPED.equalsIgnoreCase(NOMBRE)) {
                            System.out.println("Encontrado: Habitación #" + HABI[i].NUM + 
                                " | Tipo: " + HABI[i].TIPO + 
                                " | Precio: $" + HABI[i].PRECIO);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Huésped no encontrado");
                    }
                    break;
                    
                case 4:
                    // Buscar disponibles
                    System.out.println("\n=== HABITACIONES DISPONIBLES ===");
                    boolean hay_disponibles = false;
                    for (int i = 0; i < CANTIDAD; i++) {
                        if (HABI[i].DISP.equals("SI")) {
                            System.out.println("Habitación #" + HABI[i].NUM + 
                                " | Tipo: " + HABI[i].TIPO + 
                                " | Precio: $" + HABI[i].PRECIO);
                            hay_disponibles = true;
                        }
                    }
                    if (!hay_disponibles) {
                        System.out.println("No hay habitaciones disponibles");
                    }
                    break;
                    
                case 5:
                    // Eliminar habitación
                    System.out.print("Ingrese número de habitación a eliminar: ");
                    int NUM_ELIM = scanner.nextInt();
                    
                    int POS_ELIM = -1;
                    for (int i = 0; i < CANTIDAD; i++) {
                        if (HABI[i].NUM == NUM_ELIM) {
                            POS_ELIM = i;
                            break;
                        }
                    }
                    
                    if (POS_ELIM == -1) {
                        System.out.println("Habitación no encontrada");
                    } else {
                        // Desplazar elementos
                        for (int i = POS_ELIM; i < CANTIDAD - 1; i++) {
                            HABI[i] = HABI[i + 1];
                        }
                        CANTIDAD--;
                        System.out.println("Habitación eliminada");
                    }
                    break;
                    
                case 6:
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
