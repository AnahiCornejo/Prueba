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
    void testCalculoRES_A5_B10() {
        // Simular entrada: A=5, B=10
        String input = "5\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Ejecutar el main
        App.main(new String[]{});
        
        // Verificar que RES = (5 + 10) * 2 / 5 = 6.0
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("6.0"), "El resultado debe ser 6.0 cuando A=5 y B=10");
    }

    @Test
    void testCalculoRES_A10_B15() {
        // Simular entrada: A=10, B=15
        String input = "10\n15\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Ejecutar el main
        App.main(new String[]{});
        
        // Verificar que RES = (10 + 15) * 2 / 5 = 10.0
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("10.0"), "El resultado debe ser 10.0 cuando A=10 y B=15");
    }

    @Test
    void testCalculoRES_A0_B0() {
        // Simular entrada: A=0, B=0
        String input = "0\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Ejecutar el main
        App.main(new String[]{});
        
        // Verificar que RES = (0 + 0) * 2 / 5 = 0.0
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0.0"), "El resultado debe ser 0.0 cuando A=0 y B=0");
    }
}
