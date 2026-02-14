package com.jairo.poo.PaymentGateway;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProcesadorPagoTest {

    @Test
    public void testPagoConTarjetaExitoso() {
        // 1. ARRANGE: Configuramos el procesador con Tarjeta
        MetodoPago tarjeta = new TarjetaCreditoPago("1234567812345678", "12/28", "123");
        ProcesadorPago procesador = new ProcesadorPago(tarjeta);
        BigDecimal monto = new BigDecimal("100.00");

        // 2. ACT: Ejecutamos el pago
        String resultado = procesador.realizarTransaccion(monto);

        // 3. ASSERT: Verificamos que aplicó el 3% (103.00)
        assertTrue(resultado.contains("103.00"), "Debería aplicar el 3% de comisión");
        assertTrue(resultado.contains("Procesando pago"), "Deberia retornar un pago exitoso");
    }
    @Test
    public void testPagoConCriptoMonedas() {
        // 1. ARRANGE: Configuramos el procesador con Tarjeta
        MetodoPago cripto = new CriptoPago("0x12344567");
        ProcesadorPago procesador = new ProcesadorPago(cripto);
        BigDecimal monto = new BigDecimal("50.00");

        // 2. ACT: Ejecutamos el pago
        String resultado = procesador.realizarTransaccion(monto);

        // 3. ASSERT: Verificamos que aplicó el cobro
        assertTrue(resultado.contains("52.00"), "Debería el cobro de 2 criptomonedas");
        
        assertTrue(resultado.contains("Transfiriendo criptomonedas"), "Deberia retornar un pago exitoso");
    }

    @Test
    public void testPagoConPayPalExitoso() {
        // 1. ARRANGE: Configuramos el procesador con PayPal
        MetodoPago paypal = new PayPalPago("jairo@ejemplo.com");
        ProcesadorPago procesador = new ProcesadorPago(paypal);
        BigDecimal monto = new BigDecimal("100.00");

        // 2. ACT
        String resultado = procesador.realizarTransaccion(monto);

        // 3. ASSERT: Verificamos que aplicó la tarifa plana de 0.50 (100.50)
        assertTrue(resultado.contains("100.50"), "Debería aplicar la tarifa plana de 0.50");
        assertTrue(resultado.contains("al PayPal con correo jairo@ejemplo.com"), "Deberia retornar un pago exitoso");
    }

    @Test
    public void testConstructorTarjetaInvalidaLanzaExcepcion() {
        // ASSERT: Verificamos que el constructor "guardián" bloquee datos malos
        assertThrows(IllegalArgumentException.class, () -> {
            new TarjetaCreditoPago("123", "12/28", "111"); // Tarjeta muy corta
        }, "Debería fallar si la tarjeta no tiene 16 dígitos");
        assertThrows(IllegalArgumentException.class, () -> {
            new TarjetaCreditoPago("1234567812345678", "12/28", "1"); // Tarjeta muy corta
        }, "Debería fallar si la tarjeta no tiene un cvv de tres digitos");
        
    }
    @Test
    public void testConstructorPaypalInvalidaLanzaExcepcion() {
        // ASSERT: Verificamos que el constructor "guardián" bloquee datos malos
        assertThrows(IllegalArgumentException.class, () -> {
            new PayPalPago(null); // Tarjeta muy corta
        }, "Debería fallar si el correo es nulo");
        
        assertThrows(IllegalArgumentException.class, () -> {
            new PayPalPago("jairo@ejemplo_com"); // Tarjeta muy corta
        }, "Debería fallar por no contener un punto");
       
        assertThrows(IllegalArgumentException.class, () -> {
            new PayPalPago("jairoejemplo.com"); // Tarjeta muy corta
        }, "Debería fallar por falta de @");
        
    }
    @Test
    public void testConstructorCriptoInvalidaLanzaExcepcion() {
        // ASSERT: Verificamos que el constructor "guardián" bloquee datos malos
        assertThrows(IllegalArgumentException.class, () -> {
            new CriptoPago("123"); // Tarjeta muy corta
        }, "Debería fallar por cuenta invalida");
    }
    ///Test de pago fracasado
    @Test
    public void testPagoConTarjetaFallido() {
        // 1. ARRANGE: Configuramos el procesador con Tarjeta
        MetodoPago tarjeta = new TarjetaCreditoPago("1234567812345678", "12/28", "123");
        ProcesadorPago procesador = new ProcesadorPago(tarjeta);
        BigDecimal monto = new BigDecimal("9.00");

        
        assertThrows(IllegalArgumentException.class, () -> {
            procesador.realizarTransaccion(monto); // Tarjeta muy corta
        }, "Debería por valor insuficiente");
    }

    @Test
    public void testPagoConPayPalFallido() {
        // 1. ARRANGE: Configuramos el procesador con PayPal
        MetodoPago paypal = new PayPalPago("jairo@ejemplo.com");
        ProcesadorPago procesador = new ProcesadorPago(paypal);
        BigDecimal monto = new BigDecimal("110000.00");

        // 2. ACT

         assertThrows(IllegalArgumentException.class, () -> {
            procesador.realizarTransaccion(monto); // Tarjeta muy corta
        }, "Debería fallar por valor excesivo");
    }
  
   @Test
    public void testTarjetaRechazaMontoCero() {
        MetodoPago tarjeta = new TarjetaCreditoPago("1234567812345678", "12/28", "123");
        ProcesadorPago procesador = new ProcesadorPago(tarjeta);

        assertThrows(IllegalArgumentException.class, () -> {
            procesador.realizarTransaccion(BigDecimal.ZERO);
        }, "Debería fallar porque el sistema no permite pagos de $0");
    }

    @Test
    public void testTarjetaRechazaMontoNegativo() {
        MetodoPago tarjeta = new TarjetaCreditoPago("1234567812345678", "12/28", "123");
        ProcesadorPago procesador = new ProcesadorPago(tarjeta);

        assertThrows(IllegalArgumentException.class, () -> {
            procesador.realizarTransaccion(new BigDecimal("-50.00"));
        }, "Debería fallar porque no existen pagos negativos");
    }    
}