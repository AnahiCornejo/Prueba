package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer los precios de los 7 platillos
        System.out.println("Ingrese los precios de los 7 platillos:");
        double[] PRECIOS = new double[8]; // índice 1-7
        for (int i = 1; i <= 7; i++) {
            System.out.print("Precio platillo " + i + ": ");
            PRECIOS[i] = scanner.nextDouble();
        }
        
        double TOTAL_DIA = 0;
        int NUM_FACTURA = 0;
        
        System.out.println("\nIngrese 0 en número de facturas para terminar.");
        
        // Procesar facturas de clientes
        while (true) {
            System.out.print("\nIngrese número de facturas (0 para terminar): ");
            int N = scanner.nextInt();
            
            if (N == 0) {
                break;
            }
            
            double TOTAL_CLIENTE = 0;
            
            // Procesar cada factura del cliente
            for (int i = 1; i <= N; i++) {
                NUM_FACTURA++;
                System.out.println("\n--- Factura #" + NUM_FACTURA + " ---");
                
                System.out.print("Ingrese clave del platillo (1-7): ");
                int CLAVE = scanner.nextInt();
                
                System.out.print("Ingrese cantidad: ");
                int CANTIDAD = scanner.nextInt();
                
                // Calcular precio de esta línea
                if (CLAVE >= 1 && CLAVE <= 7) {
                    double PRECIO_LINEA = PRECIOS[CLAVE] * CANTIDAD;
                    System.out.println("Subtotal factura #" + NUM_FACTURA + ": " + PRECIO_LINEA);
                    TOTAL_CLIENTE += PRECIO_LINEA;
                    TOTAL_DIA += PRECIO_LINEA;
                } else {
                    System.out.println("Clave inválida");
                }
            }
            
            System.out.println("Total cliente: " + TOTAL_CLIENTE);
        }
        
        // Imprimir total del día
        System.out.println("\n=== TOTAL VENDIDO DEL DÍA ===");
        System.out.println("Total facturas: " + NUM_FACTURA);
        System.out.println("Total dinero: " + TOTAL_DIA);
        
        scanner.close();
    }
}
