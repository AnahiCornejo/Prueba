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
    void testConNumerosPositivos() {
        // Números: 5, 10, 3, 8, 2
        // Todos son positivos, PROPOS = (5+10+3+8+2)/5 = 5.6
        // PROALL = 28/5 = 5.6
        String input = "5\n5\n10\n3\n8\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_3_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("5"), "Debe haber 5 positivos");
        assertTrue(output.contains("5.6"), "Promedio debe ser 5.6");
    }

    @Test
    void testConNumerosNegativosYPositivos() {
        // Números: 10, -5, 8, -3, 2
        // Positivos: 10, 8, 2 = 3 números, suma = 20, promedio = 6.67
        // Todos: suma = 12, promedio = 2.4
        String input = "5\n10\n-5\n8\n-3\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_3_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("3"), "Debe haber 3 positivos");
        assertTrue(output.contains("6.6"), "Promedio de positivos debe ser 6.6");
    }

    @Test
    void testConUnNumero() {
        // Un solo número positivo: 10
        String input = "1\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_3_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1"), "Debe haber 1 positivo");
        assertTrue(output.contains("10.0"), "Promedio debe ser 10.0");
    }

    @Test
    void testSinNumerosPositivos() {
        // Números: -5, -10, -3
        // Positivos: ninguno, PROPOS = 0
        // PROALL = -18/3 = -6
        String input = "3\n-5\n-10\n-3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_3_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0"), "Debe haber 0 positivos");
        assertTrue(output.contains("0.0") || output.contains("Promedio de positivos: 0.0"), "Promedio de positivos debe ser 0");
    }

    @Test
    void testConCero() {
        // Números: 5, 0, 10, -3
        // Positivos: 5, 10 = 2 números, suma = 15, promedio = 7.5
        // Todos: suma = 12, promedio = 3
        String input = "4\n5\n0\n10\n-3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_3_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("2"), "Debe haber 2 positivos");
        assertTrue(output.contains("7.5"), "Promedio de positivos debe ser 7.5");
    }
}
