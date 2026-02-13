package com.jairo.poo.PaymentGateway;
import java.math.BigDecimal;
        
public interface MetodoPago {
    String procesarPago(BigDecimal monto);
}