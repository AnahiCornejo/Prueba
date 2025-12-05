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
    void testSinDescuento() {
        // Compra < 500, sin descuento
        String input = "300\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_2_8.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0%"), "Debe aplicar 0% de descuento");
        assertTrue(output.contains("300.0"), "El monto a pagar debe ser 300.0");
    }

    @Test
    void testDescuento5Porciento() {
        // Compra entre 500-1000, 5% descuento
        String input = "600\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_2_8.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("5%"), "Debe aplicar 5% de descuento");
        assertTrue(output.contains("570.0"), "Descuento de 30, monto a pagar 570.0");
    }

    @Test
    void testDescuento11Porciento() {
        // Compra entre 1001-7000, 11% descuento
        String input = "2000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_2_8.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("11%"), "Debe aplicar 11% de descuento");
        assertTrue(output.contains("1780.0"), "Descuento de 220, monto a pagar 1780.0");
    }

    @Test
    void testDescuento18Porciento() {
        // Compra entre 7001-15000, 18% descuento
        String input = "10000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_2_8.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("18%"), "Debe aplicar 18% de descuento");
        assertTrue(output.contains("8200.0"), "Descuento de 1800, monto a pagar 8200.0");
    }

    @Test
    void testDescuento25Porciento() {
        // Compra > 15000, 25% descuento
        String input = "20000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Problema_2_8.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("25%"), "Debe aplicar 25% de descuento");
        assertTrue(output.contains("15000.0"), "Descuento de 5000, monto a pagar 15000.0");
    }
}
