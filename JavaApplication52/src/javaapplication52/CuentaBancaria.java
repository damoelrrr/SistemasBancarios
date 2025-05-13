package javaapplication52;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

    private static List<CuentaBancaria> cuentasRegistradas = new ArrayList<>();
    private List<Transaccion> historial = new ArrayList<>();
    private String numeroCuenta;
    private double saldo;
    private Persona titular;

    public CuentaBancaria(String numeroCuenta, Persona titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();
        cuentasRegistradas.add(this);
    }

    public List<Transaccion> getHistorial() {
        return historial;
    }

    public static CuentaBancaria buscarCuenta(String numeroCuenta) {
        for (CuentaBancaria c : cuentasRegistradas) {
            if (c.getNumeroCuenta().equals(numeroCuenta)) {
                return c;
            }
        }
        return null;
    }

    public static List<CuentaBancaria> getCuentasRegistradas() {
        return cuentasRegistradas;
    }

    public static void eliminarCuenta(CuentaBancaria cuenta) {
        cuentasRegistradas.remove(cuenta);
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Persona getTitular() {
        return titular;
    }

    public static void setCuentasRegistradas(List<CuentaBancaria> cuentasRegistradas) {
        CuentaBancaria.cuentasRegistradas = cuentasRegistradas;
    }

    public void setHistorial(List<Transaccion> historial) {
        this.historial = historial;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public void agregarTransaccion(Transaccion transaccion) {
        historial.add(transaccion);
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            historial.add(new Transaccion("Depósito", monto, null, this));
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            historial.add(new Transaccion("Retiro", monto, this, null));
            return true;
        }
        return false;
    }

    public boolean transferirA(CuentaBancaria destino, double monto) {
        if (retirar(monto)) {
            destino.depositar(monto);
            historial.add(new Transaccion("Transferencia", monto, this, destino));
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cuenta{"
                + "número='" + numeroCuenta + '\''
                + ", saldo=" + saldo
                + ", titular=" + (titular != null ? titular.getNombre() : "Desconocido")
                + '}';
    }
}
