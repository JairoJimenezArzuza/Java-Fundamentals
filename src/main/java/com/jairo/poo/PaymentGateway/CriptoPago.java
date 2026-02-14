
package com.jairo.poo.PaymentGateway;

import java.math.BigDecimal;

public class CriptoPago implements  MetodoPago{
    private final String direccionBilletera;

    public CriptoPago(String direccionBilletera) {
        if (!direccionBilletera.startsWith("0x") || direccionBilletera.length() < 10) {
            throw new IllegalArgumentException("ERROR: Dirección de Billetera Invalida");
        }
        this.direccionBilletera = direccionBilletera;
    }
    
    
    @Override
    public String procesarPago(BigDecimal monto) {
        //Se cobraran os criptos adicionales por costo de Gas Free
        BigDecimal total = monto.add(BigDecimal.TWO);
        
        return "Transfiriendo criptomonedas, un total de "+total;
    }
    
}
