package javaapplication52;

import java.util.List;

public class SistemaBancario {

    public void depositar(CuentaBancaria cuentaDep, double monto2) {
        if (monto2 > 0) {
            cuentaDep.setSaldo(cuentaDep.getSaldo() + monto2);
            cuentaDep.getHistorial().add(new Transaccion("Depósito", monto2, null, cuentaDep));
        } else {
            System.out.println("El monto debe ser positivo.");
        }
    }

    public boolean retirar(CuentaBancaria cuenta, double monto) {
        if (monto > 0 && cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
            cuenta.getHistorial().add(new Transaccion("Retiro", monto, cuenta, null));
            return true;
        } else {
            System.out.println("Saldo insuficiente o monto invalido.");
            return false;
        }
    }

    public boolean transferir(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        if (origen == null || destino == null) {
            System.out.println("Las cuentas origen o destino no son válidas.");
            return false;
        }

        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
            return false;
        }

        if (origen.getSaldo() < monto) {
            System.out.println("Saldo insuficiente en la cuenta de origen.");
            return false;
        }

        boolean retiroExitoso = retirar(origen, monto);
        if (retiroExitoso) {
            depositar(destino, monto);
            Transaccion transaccion = new Transaccion("Transferencia", monto, origen, destino);
            origen.getHistorial().add(transaccion);
            destino.getHistorial().add(transaccion);
            return true;
        } else {
            return false;
        }
    }

    public CuentaBancaria buscarCuenta(List<CuentaBancaria> cuentas, String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }
}

