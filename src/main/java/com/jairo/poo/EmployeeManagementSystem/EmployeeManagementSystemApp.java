package com.jairo.poo.EmployeeManagementSystem;

import java.util.List;
import java.math.BigDecimal;

public class EmployeeManagementSystemApp{
    public static void main(String[] args) {
        List<Empleado> lista = List.of(
            new EmpleadoAsalariado(new BigDecimal("3000.00"),1, "Jairo", "Sistemas" ),
            new EmpleadoAsalariado(new BigDecimal("3000.00"),2, "Gabo", "Relaciones publicas" )    
        );

        NominaService service = new NominaService(lista);
        System.out.println(service.ejecutarPagoEmpleados());
    }
}