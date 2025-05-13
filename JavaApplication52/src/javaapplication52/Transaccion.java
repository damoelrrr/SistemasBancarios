package javaapplication52;

import java.util.Date;

public class Transaccion {

    private String tipo;
    private double monto;
    private Date fecha;
    private CuentaBancaria origen;
    private CuentaBancaria destino;

    public Transaccion(String tipo, double monto, CuentaBancaria origen, CuentaBancaria destino) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = new Date();
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "[" + fecha + "] " + tipo + ": $" + monto
                + (origen != null ? " desde " + origen.getNumeroCuenta() : "")
                + (destino != null ? " hacia " + destino.getNumeroCuenta() : "");
    }
}
