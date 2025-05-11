package javaapplication52;

import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

    private static List<CuentaBancaria> cuentasRegistradas = new ArrayList<>();

    private String numeroCuenta;
    private double saldo;
    private Persona titular;
    private List<Transaccion> historial;

    public CuentaBancaria(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0;
        this.historial = new ArrayList<>();
        cuentasRegistradas.add(this);
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

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            historial.add(new Transaccion("Depósito", monto, null, this));
        } else {
            System.out.println("El monto debe ser positivo.");
        }
    }

    public boolean retirar(double monto) {
        if (monto <= saldo && monto > 0) {
            saldo -= monto;
            historial.add(new Transaccion("Retiro", monto, this, null));
            return true;
        } else {
            System.out.println("Saldo insuficiente o monto inválido.");
            return false;
        }
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino != null && retirar(monto)) {
            destino.depositar(monto);
            historial.add(new Transaccion("Transferencia", monto, this, destino));

            return true;
        } else {
            System.out.println("Transferencia fallida.");
            return false;
        }
    }

    public List<Transaccion> getHistorial() {
        return historial;
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
