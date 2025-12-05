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
    void testOrdenarDescendente() {
        // Arreglo: 25, 29, 32, 52, 61, 44, 84, 52
        // Ordenado: 25, 29, 32, 44, 52, 52, 61, 84
        String input = "8\n25\n29\n32\n52\n61\n44\n84\n52\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Ejemplo_4_12.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("25, 29, 32, 44, 52, 52, 61, 84"), 
            "El arreglo debe estar ordenado correctamente");
    }

    @Test
    void testYaOrdenado() {
        // Arreglo ya ordenado: 10, 20, 30, 40, 50
        String input = "5\n10\n20\n30\n40\n50\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Ejemplo_4_12.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("10, 20, 30, 40, 50"), 
            "El arreglo debe permanecer igual si ya está ordenado");
    }

    @Test
    void testOrdenInverso() {
        // Arreglo en orden inverso: 50, 40, 30, 20, 10
        // Ordenado: 10, 20, 30, 40, 50
        String input = "5\n50\n40\n30\n20\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Ejemplo_4_12.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("10, 20, 30, 40, 50"), 
            "El arreglo debe ordenarse de menor a mayor");
    }

    @Test
    void testUnElemento() {
        // Un solo elemento
        String input = "1\n42\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Ejemplo_4_12.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("42"), 
            "Un arreglo con un elemento debe mostrarlo");
    }

    @Test
    void testConDuplicados() {
        // Arreglo con duplicados: 5, 3, 5, 1, 5, 3
        // Ordenado: 1, 3, 3, 5, 5, 5
        String input = "6\n5\n3\n5\n1\n5\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Ejemplo_4_12.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("1, 3, 3, 5, 5, 5"), 
            "El arreglo con duplicados debe ordenarse correctamente");
    }
}
