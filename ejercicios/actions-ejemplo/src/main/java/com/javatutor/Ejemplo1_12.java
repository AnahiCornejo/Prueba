package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer A y B
        System.out.print("Ingrese A: ");
        double A = scanner.nextDouble();
        
        System.out.print("Ingrese B: ");
        double B = scanner.nextDouble();
        
        // Calcular RES = (A + B) * 2 / 5
        double RES = (A + B) * 2 / 5;
        
        // Escribir RES
        System.out.println("RES = " + RES);
        
        scanner.close();
    }
}
