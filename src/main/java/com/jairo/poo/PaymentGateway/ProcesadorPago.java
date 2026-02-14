package com.jairo.poo.PaymentGateway;

import java.math.BigDecimal;

public class ProcesadorPago {
    MetodoPago pasarela;
    BigDecimal montoPago;
    
    public ProcesadorPago(MetodoPago pasarela, BigDecimal montoPago) {
        this.pasarela = pasarela;
        this.montoPago = montoPago;
    }
    
    public String pagar(){
        return  pasarela.procesarPago(montoPago);
    }
        
}
