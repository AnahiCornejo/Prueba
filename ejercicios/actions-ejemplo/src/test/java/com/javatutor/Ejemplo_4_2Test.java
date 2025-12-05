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
    void testSueldosIguales() {
        // 70 sueldos de 1000 cada uno = 70000 total, promedio 1000
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 70; i++) {
            input.append("1000\n");
        }
        System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
        
        Ejemplo_4_2.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("70000.0"), "Total debe ser 70000.0");
        assertTrue(output.contains("1000.0"), "Promedio debe ser 1000.0");
    }

    @Test
    void testSueldosVariados() {
        // 70 sueldos: 50 de 1000, 20 de 2000
        // Total = 50*1000 + 20*2000 = 50000 + 40000 = 90000
        // Promedio = 90000/70 = 1285.71...
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            input.append("1000\n");
        }
        for (int i = 0; i < 20; i++) {
            input.append("2000\n");
        }
        System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
        
        Ejemplo_4_2.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("90000.0"), "Total debe ser 90000.0");
        assertTrue(output.contains("1285.7") || output.contains("1285"), "Promedio debe ser aproximadamente 1285.71");
    }

    @Test
    void testSueldosMenor() {
        // 70 sueldos de 500 cada uno = 35000 total, promedio 500
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 70; i++) {
            input.append("500\n");
        }
        System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
        
        Ejemplo_4_2.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("35000.0"), "Total debe ser 35000.0");
        assertTrue(output.contains("500.0"), "Promedio debe ser 500.0");
    }
}
