package com.jairo.poo.PaymentGateway;

import java.math.BigDecimal;

public class PayPalPago implements MetodoPago{
    private final String correoElectronico;

    public PayPalPago(String correoElectronico) {
        
        if (correoElectronico == null || !correoElectronico.contains("@") || !correoElectronico.contains(".") ) {
            throw new IllegalArgumentException("Error: Correo electronico invalido");
        }
        this.correoElectronico = correoElectronico;
    }
    
    @Override
    public String procesarPago(BigDecimal monto) {
        if(monto.compareTo(BigDecimal.ZERO) <= 0 || monto.compareTo(new BigDecimal("10000")) > 0){
            throw new IllegalArgumentException("ERROR: Monto insuficiente");
        }
        String tarifaPlana = "0.50"; // Tarifa por transacción,sin importar a cantidad
        BigDecimal total = monto.add(new BigDecimal(tarifaPlana));
        return "Procesando pago ... $ "+total+ "al PayPal con correo "+correoElectronico;
    }
    
}
