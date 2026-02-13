/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;


public abstract class  Empleado {
    private int id;
    private String nombre;
    private String Departamento;

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
