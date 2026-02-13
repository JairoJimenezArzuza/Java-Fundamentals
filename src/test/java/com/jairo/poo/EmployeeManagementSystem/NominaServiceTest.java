/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jairo
 */
public class NominaServiceTest {
    
    @Test
public void testEjecutarPagoEmpleados() {
    System.out.println("Ejecutando prueba: ejecutarPagoEmpleados");

    // 1. ARRANGE (Preparar los datos)
    // Necesitamos una lista de empleados real, no null.
    List<Empleado> lista = List.of(
            new EmpleadoAsalariado(new BigDecimal("3000.00"),1, "Jairo", "Sistemas" ),
            new EmpleadoAsalariado(new BigDecimal("3000.00"),2, "Gabo", "Relaciones publicas" )    
        );
    NominaService instance = new NominaService(lista);

    // 2. ACT (Ejecutar la acción)
    String resultado = instance.ejecutarPagoEmpleados();

    // 3. ASSERT (Verificar los resultados)
    // El sueldo total debería ser 5000.00
    assertTrue(resultado.contains("6000.00"), "El reporte debe contener el total de 5000.00");
    assertTrue(resultado.contains("Jairo"), "El reporte debe mencionar al trabajador Jairo");
}
    @Test
    public void testSalarioNegativoDebeLanzarExcepcion() {
        // Creamos un empleado con salario negativo adrede
       List<Empleado> lista = List.of(
            new EmpleadoAsalariado(new BigDecimal("-500.00"), 1, "Persona Error", "Contabilidad")
        );
        NominaService instance = new NominaService(lista);

        // Verificamos que el sistema lance la excepción que programamos en el Service
        assertThrows(IllegalArgumentException.class, () -> {
            instance.ejecutarPagoEmpleados();
        });
    }
}
