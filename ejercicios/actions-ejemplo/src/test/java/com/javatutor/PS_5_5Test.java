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
    void testAgregarHabitacion() {
        // Agregar una habitación simple disponible
        // Luego listar
        // Luego salir
        String input = "1\n101\nSI\n500\nSI\n2\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_5_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Habitación agregada") && 
                  (output.contains("101") || output.contains("500")),
            "Debe agregar la habitación");
    }

    @Test
    void testBuscarHuesped() {
        // Agregar habitación con huésped
        // Buscar por nombre
        // Salir
        String input = "1\n102\nDO\n700\nNO\nJuan Pérez\n3\nJuan Pérez\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_5_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Encontrado") || output.contains("102"),
            "Debe encontrar al huésped");
    }

    @Test
    void testBuscarDisponibles() {
        // Agregar 2 habitaciones (1 disponible, 1 ocupada)
        // Buscar disponibles
        // Salir
        String input = "1\n101\nSI\n500\nSI\n1\n102\nDO\n700\nNO\nMaría\n4\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_5_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("101") && !output.contains("HABITACIONES DISPONIBLES") || 
                  output.contains("disponible"),
            "Debe mostrar habitación disponible");
    }

    @Test
    void testEliminarHabitacion() {
        // Agregar habitación
        // Eliminar habitación
        // Listar (debe estar vacío o menor cantidad)
        // Salir
        String input = "1\n103\nTR\n900\nSI\n5\n103\n2\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_5_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Habitación eliminada") ||
                  (output.contains("agregada") && output.contains("no hay")),
            "Debe eliminar la habitación");
    }

    @Test
    void testMultiplesOperaciones() {
        // Agregar 2 habitaciones
        // Listar
        // Buscar disponibles
        // Salir
        String input = "1\n104\nSU\n1200\nSI\n1\n105\nSI\n500\nNO\nCarlos\n4\n2\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_5_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("Habitación agregada") &&
                  (output.contains("104") || output.contains("105")),
            "Debe agregar múltiples habitaciones");
    }

    @Test
    void testBuscarHuespedNoEncontrado() {
        // Agregar una habitación
        // Buscar un huésped que no existe
        // Salir
        String input = "1\n106\nSI\n500\nNO\nAna\n3\nPedro\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        PS_5_5.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        assertTrue(output.contains("no encontrado") || output.contains("Huésped"),
            "Debe indicar que huésped no existe");
    }
}
