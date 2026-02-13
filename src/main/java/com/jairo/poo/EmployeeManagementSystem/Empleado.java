package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;


public abstract class  Empleado {
    private final int id;
    private final String nombre;
    private final String Departamento;

    public Empleado(int id, String nombre, String Departamento) {
        this.id = id;
        this.nombre = nombre;
        this.Departamento = Departamento;
    }
    
    public abstract BigDecimal calcularSueldo();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return Departamento;
    }  
}
