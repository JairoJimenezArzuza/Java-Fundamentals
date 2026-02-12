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
    
    public abstract BigDecimal calcularSueldo();
}
