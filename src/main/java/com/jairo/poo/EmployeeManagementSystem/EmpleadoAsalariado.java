package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;

public class EmpleadoAsalariado extends Empleado{
    private BigDecimal sueldo;

    public EmpleadoAsalariado(BigDecimal sueldo, int id, String nombre, String Departamento) {
        super(id, nombre, Departamento);
        this.sueldo = sueldo;
    }
    /**
     * @return
     */
    @Override
    public BigDecimal calcularSueldo() {
        return sueldo;
    }
    
}