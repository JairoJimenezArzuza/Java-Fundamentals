package com.jairo.poo.PaymentGateway;

import java.math.BigDecimal;

public class TarjetaCreditoPago implements MetodoPago{
    private final String numeroTarjeta;
    private final String fechaExpiracion;
    private final String cvv; 

    public TarjetaCreditoPago(String numeroTarjeta, String fechaExpiracion, String cvv) {
        
        if(numeroTarjeta.length() != 16){
            throw new IllegalArgumentException("Error: Numero de tarjeta invalido, no cumple longitud requerida");
        }
        
        if (cvv.length() != 3) {
            throw new IllegalArgumentException("Error: cvv Invalido, su longitud no es tres, es "+ cvv);
        }
            
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
    }
   
    @Override
    public String procesarPago(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.TEN) < 0) {
            throw new IllegalArgumentException("Error: monto invalido");
        }   
        String transferenciaMasComisiones = "1.03"; // Se tiene un 3% de comsiones sobre tansferencia
        BigDecimal total = monto.multiply(new BigDecimal(transferenciaMasComisiones));
        
        return "Procesando pago ... $ " + total + " Con tarjeta de credito";
    }  
}
