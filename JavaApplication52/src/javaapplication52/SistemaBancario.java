package javaapplication52;

import java.util.List;
import java.util.Scanner;

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

       
        return origen.transferirA(destino, monto);
    }

    public CuentaBancaria buscarCuenta(List<CuentaBancaria> cuentas, String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public static void modificarDatosPersonales(RegistroVerificado cuenta, Scanner scan) {
        System.out.println("¿Desea actualizar datos personales? (si/no):");
        String modi = scan.nextLine();

        if (modi.equalsIgnoreCase("si")) {
            cuenta.modificarRegistro();
        } else if (modi.equalsIgnoreCase("no")) {
            System.out.println("No se realizarán cambios en su registro.");
        } else {
            System.out.println("Opción no válida.");
        }
    }

}
