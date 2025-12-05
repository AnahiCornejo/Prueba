package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer el monto de la compra
        System.out.print("Ingrese el monto de la compra: ");
        double COMPRA = scanner.nextDouble();
        
        // Determinar el descuento según el monto
        double PORCEN;
        if (COMPRA < 500) {
            PORCEN = 0;
        } else if (COMPRA >= 500 && COMPRA <= 1000) {
            PORCEN = 5;
        } else if (COMPRA > 1000 && COMPRA <= 7000) {
            PORCEN = 11;
        } else if (COMPRA > 7000 && COMPRA <= 15000) {
            PORCEN = 18;
        } else {
            PORCEN = 25;
        }
        
        // Calcular el descuento
        double DESCUENTO = COMPRA * PORCEN / 100;
        
        // Calcular el monto a pagar
        double PAGAR = COMPRA - DESCUENTO;
        
        // Imprimir resultados
        System.out.println("Monto de compra: " + COMPRA);
        System.out.println("Porcentaje de descuento: " + PORCEN + "%");
        System.out.println("Descuento: " + DESCUENTO);
        System.out.println("Monto a pagar: " + PAGAR);
        
        scanner.close();
    }
}
