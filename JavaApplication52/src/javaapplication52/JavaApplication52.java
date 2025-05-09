package javaapplication52;

import java.util.Scanner;

public class JavaApplication52 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        RegistroVerificado cuenta = new RegistroVerificado();

        
        boolean sesionIniciada = false;

        System.out.println("¿Ya tienes una cuenta registrada? (si/no): ");
        String respuesta = cuenta.getScanner().nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            sesionIniciada = cuenta.iniciarSesion();
        } else if (respuesta.equalsIgnoreCase("no")) {
            cuenta.registrarCuenta();
            sesionIniciada = cuenta.iniciarSesion();
        } else {
            System.out.println("Respuesta no válida. El programa terminará.");
            cuenta.cerrarPrincipio();
            return;
        }

        if (!sesionIniciada) {
            System.out.println("No se pudo iniciar sesión. Terminando programa.");
            cuenta.cerrarScanner();
            return;
        }

        System.out.println("¿Desea actualizar datos personales? (si/no):");
        String modi = scan.nextLine();

        if (modi.equalsIgnoreCase("si")) {
            cuenta.modificarRegistro();
        } else if (modi.equalsIgnoreCase("no")) {
            System.out.println("No se realizarán cambios en su registro.");
        } else {
            System.out.println("Opción no válida.");
        }

        System.out.println("¿Que desea hacer?");
        System.out.println("Transferencias entre cuentas");
        System.out.println("Depositos ");
        System.out.println("Retiros");
        System.out.println("Pagos de servicios(facturas) ");
        System.out.println("Consultar saldo");
        System.out.println("Consultar historial de movimiento");
        System.out.println("Solicitar prestamo ");
        System.out.println("Regitro de pago de prestamos");
        
        cuenta.cerrarScanner();

    }
    
}
