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
    void testMatriz2x2() {
        // Matriz 2x2: [[1,2],[3,4]]
        // B[0]: i%4=0, suma fila 0 = 1+2 = 3
        // B[1]: i%4=1, suma columna 1 = 2+4 = 6
        String input = "2\n1\n2\n3\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_4_26.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("3.0") || output.contains("B[0] = 3"), 
            "B[0] debe ser 3.0 (suma fila 0)");
        assertTrue(output.contains("6.0") || output.contains("B[1] = 6"), 
            "B[1] debe ser 6.0 (suma columna 1)");
    }

    @Test
    void testMatriz4x4() {
        // Matriz 4x4 con valores 1
        // [[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]]
        // B[0]: i%4=0, suma fila 0 = 4
        // B[1]: i%4=1, suma columna 1 = 4
        // B[2]: i%4=2, suma diagonal = 4
        // B[3]: i%4=3, suma A[1]*diagonal = 1+1+1+1 = 4
        String input = "4\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_4_26.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("4.0") || output.contains("4"), 
            "Los valores de B deben ser 4.0");
    }

    @Test
    void testMatriz3x3() {
        // Matriz 3x3: [[1,2,3],[4,5,6],[7,8,9]]
        // B[0]: i%4=0, suma fila 0 = 1+2+3 = 6
        // B[1]: i%4=1, suma columna 1 = 2+5+8 = 15
        // B[2]: i%4=2, suma diagonal = 1+5+9 = 15
        String input = "3\n1\n2\n3\n4\n5\n6\n7\n8\n9\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_4_26.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("6.0") || output.contains("B[0] = 6"), 
            "B[0] debe ser 6.0 (suma fila 0)");
        assertTrue(output.contains("15.0") || output.contains("B[1] = 15"), 
            "B[1] debe ser 15.0 (suma columna 1)");
    }

    @Test
    void testMatrizIdentidad() {
        // Matriz identidad 4x4
        // [[1,0,0,0],[0,1,0,0],[0,0,1,0],[0,0,0,1]]
        // B[0]: suma fila 0 = 1
        // B[1]: suma columna 1 = 1
        // B[2]: suma diagonal = 4
        // B[3]: suma A[1]*diagonal = 0+1+0+0 = 1
        String input = "4\n1\n0\n0\n0\n0\n1\n0\n0\n0\n0\n1\n0\n0\n0\n0\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_4_26.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1.0") || output.contains("4.0"), 
            "Debe contener valores esperados");
    }

    @Test
    void testMatriz5x5Ceros() {
        // Matriz 5x5 de ceros
        // Todos los valores de B deben ser 0
        StringBuilder input = new StringBuilder("5\n");
        for (int i = 0; i < 25; i++) {
            input.append("0\n");
        }
        System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
        
        PS_4_26.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("0.0") || output.contains("B[0] = 0"), 
            "Todos los valores de B deben ser 0.0");
    }
}
