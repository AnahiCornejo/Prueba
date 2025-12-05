package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer el monto inicial y la tasa de interés
        System.out.print("Ingrese el monto de dinero (MD): ");
        double MD = scanner.nextDouble();
        
        System.out.print("Ingrese la tasa de interés mensual (TASA): ");
        double TASA = scanner.nextDouble();
        
        // Calcular el monto final después de 1 mes
        // MF = MD + (MD * TASA / 100)
        double MF = MD + (MD * TASA / 100);
        
        // Imprimir resultados
        System.out.println("Monto inicial: " + MD);
        System.out.println("Tasa de interés mensual: " + TASA + "%");
        System.out.println("Interés ganado: " + (MD * TASA / 100));
        System.out.println("Monto final al mes: " + MF);
        
        scanner.close();
    }
}
