package com.javatutor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AppTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private final java.io.InputStream standardIn = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void testAprobado() {
        // Simular entrada: MAT=12345, CAL1-5 con promedio 7.0 (APROBADO)
        String input = "12345\n7\n7\n7\n7\n7\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Ejecutar el main
        App.main(new String[]{});
        
        // Verificar que imprima APROBADO y PRO = 7.0
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("APROBADO"), "Debe imprimir APROBADO cuando PRO >= 6");
        assertTrue(output.contains("7.0"), "El promedio debe ser 7.0");
        assertTrue(output.contains("12345"), "Debe imprimir la matrícula 12345");
    }

    @Test
    void testNoAprobado() {
        // Simular entrada: MAT=54321, CAL1-5 con promedio 5.0 (NO APROBADO)
        String input = "54321\n5\n5\n5\n5\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Ejecutar el main
        App.main(new String[]{});
        
        // Verificar que imprima NO APROBADO y PRO = 5.0
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("NO APROBADO"), "Debe imprimir NO APROBADO cuando PRO < 6");
        assertTrue(output.contains("5.0"), "El promedio debe ser 5.0");
        assertTrue(output.contains("54321"), "Debe imprimir la matrícula 54321");
    }

    @Test
    void testPromedio6Aprobado() {
        // Simular entrada: MAT=99999, promedio exacto de 6.0 (APROBADO)
        String input = "99999\n6\n6\n6\n6\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Ejecutar el main
        App.main(new String[]{});
        
        // Verificar que imprima APROBADO con promedio 6.0
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("APROBADO"), "Con promedio 6.0 debe aprobar");
        assertTrue(output.contains("6.0"), "El promedio debe ser 6.0");
    }
}
