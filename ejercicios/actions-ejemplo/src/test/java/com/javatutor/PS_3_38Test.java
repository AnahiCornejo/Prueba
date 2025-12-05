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
    void testFacturaSimple() {
        // Precios: 45, 50, 58, 70, 80, 90, 100
        // Cliente 1: 1 factura con platillo 1 (clave=1), cantidad=2
        // Platillo 1 = 45, total = 45 * 2 = 90
        String input = "45\n50\n58\n70\n80\n90\n100\n" +
                       "1\n" +
                       "1\n2\n" +
                       "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_3_38.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("90.0"), "Total debe ser 90.0");
    }

    @Test
    void testMultiplesFacturas() {
        // Precios: 45, 50, 58, 70, 80, 90, 100
        // Cliente 1: 2 facturas
        //   - Factura 1: platillo 1, cantidad 2 = 45*2 = 90
        //   - Factura 2: platillo 2, cantidad 1 = 50*1 = 50
        // Total cliente = 140, Total día = 140
        String input = "45\n50\n58\n70\n80\n90\n100\n" +
                       "2\n" +
                       "1\n2\n" +
                       "2\n1\n" +
                       "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_3_38.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("140.0"), "Total día debe ser 140.0");
    }

    @Test
    void testMultiplesClientes() {
        // Precios: 45, 50, 58, 70, 80, 90, 100
        // Cliente 1: 1 factura con platillo 1, cantidad 2 = 90
        // Cliente 2: 1 factura con platillo 2, cantidad 1 = 50
        // Total día = 140
        String input = "45\n50\n58\n70\n80\n90\n100\n" +
                       "1\n" +
                       "1\n2\n" +
                       "1\n" +
                       "2\n1\n" +
                       "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_3_38.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("140.0"), "Total día debe ser 140.0");
        assertTrue(output.contains("2"), "Debe haber 2 facturas");
    }

    @Test
    void testPlatillosCaro() {
        // Precios: 100, 150, 200, 250, 300, 350, 400
        // Cliente 1: 1 factura con platillo 7, cantidad 3
        // Total = 400 * 3 = 1200
        String input = "100\n150\n200\n250\n300\n350\n400\n" +
                       "1\n" +
                       "7\n3\n" +
                       "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_3_38.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1200.0"), "Total debe ser 1200.0");
    }

    @Test
    void testSinVentas() {
        // Solo ingresa precios y termina sin facturas
        String input = "45\n50\n58\n70\n80\n90\n100\n" +
                       "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_3_38.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0.0") || output.contains("Total dinero: 0"), 
            "Total debe ser 0.0");
    }
}
