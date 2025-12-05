package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer la categoría y el monto
        System.out.print("Ingrese la categoría (1, 2, 3, 4): ");
        int CATE = scanner.nextInt();
        
        System.out.print("Ingrese el monto a pagar: ");
        double MONTO = scanner.nextDouble();
        
        // Determinar el descuento según la categoría
        double DESCUENTO;
        switch (CATE) {
            case 1:
                DESCUENTO = MONTO * 35 / 100;
                break;
            case 2:
                DESCUENTO = MONTO * 22 / 100;
                break;
            case 3:
                DESCUENTO = MONTO * 15 / 100;
                break;
            case 4:
                DESCUENTO = MONTO * 5 / 100;
                break;
            default:
                DESCUENTO = 0;
        }
        
        // Calcular el monto final
        double MONTO_FINAL = MONTO - DESCUENTO;
        
        // Imprimir resultados
        System.out.println("Categoría: " + CATE);
        System.out.println("Monto original: " + MONTO);
        System.out.println("Descuento: " + DESCUENTO);
        System.out.println("Monto a pagar: " + MONTO_FINAL);
        
        scanner.close();
    }
}
