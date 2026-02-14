package com.jairo.poo.PaymentGateway;

import java.math.BigDecimal;

public class ProcesadorPago {
    private final MetodoPago pasarela;

    // El constructor solo configura QUÉ método de pago usaremos
    public ProcesadorPago(MetodoPago pasarela) {
        this.pasarela = pasarela;
    }

    // El método recibe el monto, permitiendo usar el mismo procesador para varios pagos
    public String realizarTransaccion(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto a pagar debe ser mayor a cero");
        }
        return pasarela.procesarPago(monto);
    }
}
