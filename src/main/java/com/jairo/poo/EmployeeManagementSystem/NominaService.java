
package com.jairo.poo.EmployeeManagementSystem;

import java.math.BigDecimal;
import java.util.List;

public class NominaService{
    private final List<Empleado> listaEmpleados;

    public NominaService(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    public String ejecutarPagoEmpleados(){
        StringBuilder mensaje = new StringBuilder("=== REPORTE DE PAGO ===\n");
        BigDecimal sueldoTotalCalculado = BigDecimal.ZERO;
        for(Empleado ls:listaEmpleados){
            mensaje.append("\n");
            BigDecimal sueldoBig = ls.calcularSueldo();
       
            if (sueldoBig.compareTo(BigDecimal.ZERO) <= 0) {
               throw  new IllegalArgumentException("Error: Empleado "+ls.getId()+" Tiene un salario no valido "+sueldoBig);
            }else{
                mensaje.append("Trabajador ").append(ls.getId())
                   .append(": $").append(sueldoBig);
                sueldoTotalCalculado = sueldoTotalCalculado.add(sueldoBig);
            }
        }
        mensaje.append("\n--------------------------\n").append(sueldoTotalCalculado);
    return mensaje.toString();        
    }

}