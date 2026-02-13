package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;

public class EmpleadoFreelancers extends Empleado{
    private BigDecimal sueldoPorProyecto;

    public EmpleadoFreelancers(BigDecimal sueldoPorProyecto, int id, String nombre, String Departamento) {
        super(id, nombre, Departamento);
        this.sueldoPorProyecto = sueldoPorProyecto;
    }
    
    @Override
    public BigDecimal calcularSueldo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}