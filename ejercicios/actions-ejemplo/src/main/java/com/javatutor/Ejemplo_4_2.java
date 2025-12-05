package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Inicializar el contador y la suma
        int CONT = 0;
        double SUELDOS = 0;
        
        // Leer los 70 sueldos
        while (CONT < 70) {
            System.out.print("Ingrese sueldo " + (CONT + 1) + ": ");
            double SUELDO = scanner.nextDouble();
            
            // Acumular el sueldo
            SUELDOS = SUELDOS + SUELDO;
            
            // Incrementar contador
            CONT = CONT + 1;
        }
        
        // Calcular el promedio
        double PROM = SUELDOS / 70;
        
        // Imprimir resultados
        System.out.println("Total de sueldos: " + SUELDOS);
        System.out.println("Promedio de sueldos: " + PROM);
        
        scanner.close();
    }
}
