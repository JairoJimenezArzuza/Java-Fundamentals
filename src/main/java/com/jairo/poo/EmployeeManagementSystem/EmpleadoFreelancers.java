package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;

public class EmpleadoFreelancers extends Empleado{
    private final BigDecimal sueldoPorProyecto;

    public EmpleadoFreelancers(BigDecimal sueldoPorProyecto, int id, String nombre, String Departamento) {
        super(id, nombre, Departamento);
        this.sueldoPorProyecto = sueldoPorProyecto;
    }
    
    @Override
    public BigDecimal calcularSueldo() {
        return sueldoPorProyecto;
    }
    
}