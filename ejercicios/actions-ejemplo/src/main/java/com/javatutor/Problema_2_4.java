package com.javatutor;

import java.util.Scanner;

// No borrar el paquete o el codigo nunca va funcionar

// Tampoco la clase, siempre debe ser App
public class App {
    public static void main(String[] args) {
        // Tu codigo va aqui
        Scanner scanner = new Scanner(System.in);
        
        // Leer MAT y las 5 calificaciones
        System.out.print("Ingrese MAT (matricula): ");
        int MAT = scanner.nextInt();
        
        System.out.print("Ingrese CAL1: ");
        double CAL1 = scanner.nextDouble();
        
        System.out.print("Ingrese CAL2: ");
        double CAL2 = scanner.nextDouble();
        
        System.out.print("Ingrese CAL3: ");
        double CAL3 = scanner.nextDouble();
        
        System.out.print("Ingrese CAL4: ");
        double CAL4 = scanner.nextDouble();
        
        System.out.print("Ingrese CAL5: ");
        double CAL5 = scanner.nextDouble();
        
        // Calcular PRO = (CAL1 + CAL2 + CAL3 + CAL4 + CAL5) / 5
        double PRO = (CAL1 + CAL2 + CAL3 + CAL4 + CAL5) / 5;
        
        // Verificar si PRO >= 6
        String estado;
        if (PRO >= 6) {
            estado = "APROBADO";
        } else {
            estado = "NO APROBADO";
        }
        
        // Imprimir resultados
        System.out.println("MAT: " + MAT);
        System.out.println("PRO: " + PRO);
        System.out.println("Estado: " + estado);
        
        scanner.close();
    }
}
