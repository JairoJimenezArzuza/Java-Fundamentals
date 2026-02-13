package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;

public class EmpleadoPorHora extends Empleado{
    private int numHoras;
    private int tarifaHora;

    public EmpleadoPorHora(int numHoras, int tarifaHora, int id, String nombre, String Departamento) {
        super(id, nombre, Departamento);
        this.numHoras = numHoras;
        this.tarifaHora = tarifaHora;
    }
    /*
        @return
    */
    @Override
    public BigDecimal calcularSueldo() {
        return BigDecimal.valueOf(numHoras * tarifaHora);
    }

    public int getNumHoras() {
        return numHoras;
    }

    public int getTarifaHora() {
        return tarifaHora;
    }   
}