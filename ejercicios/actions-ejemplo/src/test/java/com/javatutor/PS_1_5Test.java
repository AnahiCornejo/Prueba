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
    void testInteresSencillo() {
        // MD = 1000, TASA = 5%
        // Interés = 1000 * 5 / 100 = 50
        // MF = 1000 + 50 = 1050
        String input = "1000\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_1_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1050.0"), "Monto final debe ser 1050.0");
        assertTrue(output.contains("50.0"), "Interés ganado debe ser 50.0");
    }

    @Test
    void testInteresAlto() {
        // MD = 5000, TASA = 10%
        // Interés = 5000 * 10 / 100 = 500
        // MF = 5000 + 500 = 5500
        String input = "5000\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_1_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("5500.0"), "Monto final debe ser 5500.0");
        assertTrue(output.contains("500.0"), "Interés ganado debe ser 500.0");
    }

    @Test
    void testInteresUnPorCiento() {
        // MD = 2000, TASA = 1%
        // Interés = 2000 * 1 / 100 = 20
        // MF = 2000 + 20 = 2020
        String input = "2000\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_1_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("2020.0"), "Monto final debe ser 2020.0");
        assertTrue(output.contains("20.0"), "Interés ganado debe ser 20.0");
    }

    @Test
    void testInteresConDecimales() {
        // MD = 1000.50, TASA = 2.5%
        // Interés = 1000.50 * 2.5 / 100 = 25.0125
        // MF = 1000.50 + 25.0125 = 1025.5125
        String input = "1000.50\n2.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_1_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1025.5"), "Monto final debe ser aproximadamente 1025.51");
        assertTrue(output.contains("25.0"), "Interés ganado debe ser aproximadamente 25.01");
    }

    @Test
    void testMontoGrande() {
        // MD = 100000, TASA = 3%
        // Interés = 100000 * 3 / 100 = 3000
        // MF = 100000 + 3000 = 103000
        String input = "100000\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_1_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("103000.0"), "Monto final debe ser 103000.0");
        assertTrue(output.contains("3000.0"), "Interés ganado debe ser 3000.0");
    }
}
