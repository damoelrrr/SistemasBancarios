package javaapplication52;

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
            System.out.println("Saldo insuficiente o monto inválido.");
            return false;
        }
    }

    public boolean transferir(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        if (destino != null && retirar(origen, monto)) {
            depositar(destino, monto);
            origen.getHistorial().add(new Transaccion("Transferencia", monto, origen, destino));
            return true;
        } else {
            System.out.println("Transferencia fallida.");
            return false;
        }
    }

}

