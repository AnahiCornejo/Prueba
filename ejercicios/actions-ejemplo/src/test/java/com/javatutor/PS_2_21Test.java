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
    void testCategoria1() {
        // Categoría 1: 35% descuento
        // Monto = 1000, Descuento = 350, Final = 650
        String input = "1\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_2_21.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("350.0"), "Descuento debe ser 350.0");
        assertTrue(output.contains("650.0"), "Monto final debe ser 650.0");
    }

    @Test
    void testCategoria2() {
        // Categoría 2: 22% descuento
        // Monto = 1000, Descuento = 220, Final = 780
        String input = "2\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_2_21.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("220.0"), "Descuento debe ser 220.0");
        assertTrue(output.contains("780.0"), "Monto final debe ser 780.0");
    }

    @Test
    void testCategoria3() {
        // Categoría 3: 15% descuento
        // Monto = 1000, Descuento = 150, Final = 850
        String input = "3\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_2_21.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("150.0"), "Descuento debe ser 150.0");
        assertTrue(output.contains("850.0"), "Monto final debe ser 850.0");
    }

    @Test
    void testCategoria4() {
        // Categoría 4: 5% descuento
        // Monto = 1000, Descuento = 50, Final = 950
        String input = "4\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_2_21.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("50.0"), "Descuento debe ser 50.0");
        assertTrue(output.contains("950.0"), "Monto final debe ser 950.0");
    }

    @Test
    void testCategoriaInvalida() {
        // Categoría inválida: sin descuento
        // Monto = 1000, Descuento = 0, Final = 1000
        String input = "5\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_2_21.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0.0"), "Descuento debe ser 0.0");
        assertTrue(output.contains("1000.0"), "Monto final debe ser 1000.0");
    }

    @Test
    void testMontoConDecimales() {
        // Categoría 1: 35% descuento
        // Monto = 500.50, Descuento = 175.175, Final = 325.325
        String input = "1\n500.50\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_2_21.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("175.1") || output.contains("175.17"), "Descuento debe ser aproximadamente 175.17");
        assertTrue(output.contains("325.3") || output.contains("325.32"), "Monto final debe ser aproximadamente 325.32");
    }
}
