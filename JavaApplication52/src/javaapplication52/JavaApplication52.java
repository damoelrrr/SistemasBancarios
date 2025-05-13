package javaapplication52;

import java.util.List;
import java.util.Scanner;
import static javaapplication52.CuentaBancaria.buscarCuenta;
import static javaapplication52.Grafo.buscarPersonaPorDocumento;
import static javaapplication52.SistemaBancario.modificarDatosPersonales;
import javaapplication52.CuentaBancaria;

public class JavaApplication52 {

    public static void main(String[] args) {
        SistemaBancario sistema = new SistemaBancario();
        Scanner scan = new Scanner(System.in);
        Grafo grafo = new Grafo();

        RegistroVerificado cuenta = new RegistroVerificado();

        boolean sesionIniciada = false;

        while (true) {
            sesionIniciada = false;

            System.out.println("¿Ya tienes una cuenta registrada? (si/no): ");
            String respuesta = cuenta.getScanner().nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                sesionIniciada = cuenta.iniciarSesion();
            } else if (respuesta.equalsIgnoreCase("no")) {
                System.out.println("Desea crear una cuenta(si/no)");
                String respuest2a = cuenta.getScanner().nextLine();
                if (respuest2a.equalsIgnoreCase("si")) {
                    cuenta.registrarCuenta();
                    sesionIniciada = cuenta.iniciarSesion();
                } else if (respuest2a.equalsIgnoreCase("no")) {
                    cuenta.cerrarPrincipio();
                }

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

            modificarDatosPersonales(cuenta, scan);

            while (sesionIniciada) {
                System.out.println("¿Que desea hacer?");
                System.out.println("1. Transferencias entre cuentas");
                System.out.println("2. Depositos y Retiros ");
                System.out.println("3. Pagos de servicios(facturas) ");
                System.out.println("4. Consultar saldo");
                System.out.println("5. Consultar historial de movimiento");
                System.out.println("6. Solicitar prestamo ");
                System.out.println("7. Regitro de pago de prestamos");
                System.out.println("8. Ver mis conexiones");
                System.out.println("9. Actualizar datos personales");
                System.out.println("10. Salir");
                
                int ine = scan.nextInt();
                scan.nextLine();
                switch (ine) {
                    case 1:
                        System.out.println("Escriba el numero de cuenta de origen:");
                        String origenCuenta = scan.nextLine();

                        System.out.println("Ingrese el numero de cuenta destino:");
                        String destinoCuenta = scan.nextLine();

                        System.out.println("Ingrese el monto a transferir:");
                        double monto = scan.nextDouble();
                        scan.nextLine();
                        System.out.println("Ingrese el documento de la persona de origen:");
                        String docA = scan.nextLine();  

                        System.out.println("Ingrese el documento de la persona de destino:");
                        String docB = scan.nextLine(); 

                        Persona personaOrigen = buscarPersonaPorDocumento(grafo, docA);
                        Persona personaDestino = buscarPersonaPorDocumento(grafo, docB);

                        if (personaOrigen != null && personaDestino != null) {
                            
                             CuentaBancaria cuentaOrigen = personaOrigen.getCuentaBancaria(origenCuenta);
                             CuentaBancaria cuentaDestino = personaDestino.getCuentaBancaria(destinoCuenta);

                            if (cuentaOrigen != null && cuentaDestino != null) {
                                
                                boolean exito = sistema.transferir(cuentaOrigen, cuentaDestino, monto);
                                if (exito) {
                                    System.out.println("Transferencia realizada con éxito.");
                                    
                                    grafo.conectarPersonas(personaOrigen, personaDestino);
                                    System.out.println("Usuarios conectados en el grafo.");
                                } else {
                                    System.out.println("No se pudo realizar la transferencia.");
                                }
                            } else {
                                System.out.println("Una o ambas personas no tienen cuenta bancaria asociada.");
                            }
                        } else {
                            System.out.println("Una o ambas personas no fueron encontradas en el sistema.");
                        }
                        break;
                    case 2:
                        System.out.println("Que desea hacer ?");
                        System.out.println("1. Depositos");
                        System.out.println("2. Retiros");
                        System.out.println("3. volver al menu principal");
                        int desea = scan.nextInt();
                        scan.nextLine();
                        switch (desea) {
                            case 1:
                                System.out.print("Ingrese su numero de cuenta: ");
                                String numeroCuenta = scan.nextLine();
                                CuentaBancaria cuentaDep = buscarCuenta(numeroCuenta);
                                if (cuentaDep != null) {
                                    System.out.print("Ingrese el monto a depositar: ");
                                    double monto2 = scan.nextDouble();
                                    scan.nextLine();
                                    sistema.depositar(cuentaDep, monto2);
                                    System.out.println("Deposito exitoso.");
                                } else {
                                    System.out.println("Cuenta no encontrada.");
                                }
                                break;
                            case 2:
                                System.out.print("Número de cuenta: ");
                                String cuentaRetiro = scan.nextLine();
                                CuentaBancaria cuentaR = buscarCuenta(cuentaRetiro);
                                if (cuentaR != null) {
                                    System.out.print("Monto a retirar: ");
                                    double montoRetiro = scan.nextDouble();
                                    scan.nextLine();
                                    if (sistema.retirar(cuentaR, montoRetiro)) {
                                        System.out.println("Retiro exitoso.");
                                    } else {
                                        System.out.println("No se pudo realizar el retiro.");
                                    }
                                } else {
                                    System.out.println("Cuenta no encontrada.");
                                }
                                break;
                            default:
                                System.out.println("Opcion invalida. Intente de nuevo.");
                                continue;
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese su número de cuenta para pagar facturas:");
                        String cuentaPago = scan.nextLine();
                        CuentaBancaria cuentaP = buscarCuenta(cuentaPago);
                        if (cuentaP != null) {

                            loopFacturas:
                            while (true) {
                                System.out.println("¿Cual factura desea implementar?");
                                System.out.println("Facturas:");
                                System.out.println("1. Agua");
                                System.out.println("2. Basura");
                                System.out.println("3. Al sueldo del presidente");
                                System.out.println("4. Electricidad");
                                System.out.println("5. Salir");

                                int fac;
                                try {
                                    fac = Integer.parseInt(scan.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada inválida. Intente de nuevo.");
                                    continue;
                                }

                                double montoFactura = 0;
                                boolean pagoExitoso = false;

                                switch (fac) {
                                    case 1:
                                        System.out.println("Ingrese el consumo de agua en m³:");
                                        double consumoAgua = Double.parseDouble(scan.nextLine());
                                        monto = consumoAgua * 3000;
                                        System.out.println("Total a pagar por agua: $" + monto);
                                        break;

                                    case 2:
                                        System.out.println("Factura fija de recolección de basura.");
                                        monto = 20000;
                                        System.out.println("Total a pagar por basura: $" + monto);
                                        break;

                                    case 3:
                                        System.out.println("Contribucion voluntaria al sueldo del presidente.");
                                        System.out.println("Ingrese cuanto desea aportar:");
                                        monto = Double.parseDouble(scan.nextLine());
                                        System.out.println("Gracias por su aporte de $" + monto);
                                        break;

                                    case 4:
                                        System.out.println("Ingrese el consumo de electricidad en kWh:");
                                        double consumoLuz = Double.parseDouble(scan.nextLine());
                                        monto = consumoLuz * 800;
                                        System.out.println("Total a pagar por electricidad: $" + monto);
                                        break;

                                    case 5:
                                        System.out.println("Saliendo del sistema. ¡Gracias!");
                                        break loopFacturas;
                                    default:
                                        System.out.println("Opcion invalida. Intente de nuevo.");
                                        continue;
                                }

                                if (fac > 0) {
                                    if (cuentaP.getSaldo() >= monto) {
                                        cuentaP.setSaldo(cuentaP.getSaldo() - monto);
                                        System.out.println("Pago realizado exitosamente. Nuevo saldo: $" + cuentaP.getSaldo());
                                    } else {
                                        System.out.println("Saldo insuficiente para realizar el pago.");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese el número de cuenta para consultar el saldo: ");
                        String cuentaConsulta = scan.nextLine();

                        CuentaBancaria cuentaSaldo = buscarCuenta(cuentaConsulta);
                        if (cuentaSaldo != null) {
                            System.out.println("Saldo actual de la cuenta " + cuentaSaldo.getNumeroCuenta() + ": $" + cuentaSaldo.getSaldo());
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese el número de cuenta para ver el historial: ");
                        String cuentaHistorial = scan.nextLine();

                        CuentaBancaria cuentaH = buscarCuenta(cuentaHistorial);
                        if (cuentaH != null) {
                            System.out.println("Historial de movimientos de la cuenta " + cuentaH.getNumeroCuenta() + ":");
                            if (cuentaH.getHistorial().isEmpty()) {
                                System.out.println("No hay transacciones registradas.");
                            } else {
                                for (Transaccion t : cuentaH.getHistorial()) {
                                    System.out.println(t);
                                }
                            }
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                        break;

                    case 6:
                        System.out.println("Ingrese su número de cuenta:");
                        String numCuentaPrestamo = scan.nextLine();
                        CuentaBancaria cuentaPrestamo = buscarCuenta(numCuentaPrestamo);

                        if (cuentaPrestamo == null) {
                            System.out.println("Cuenta no encontrada.");
                            break;
                        }

                        System.out.println("Ingrese sus ingresos mensuales:");
                        double ingresos = scan.nextDouble();
                        scan.nextLine();

                        System.out.println("¿En qué trabaja?");
                        String trabajo = scan.nextLine();

                        System.out.println("¿Cuántos años lleva trabajando en esa empresa?");
                        int anios = scan.nextInt();

                        System.out.println("¿Tiene propiedades? (si/no)");
                        String propiedades = scan.next();
                        scan.nextLine();

                        double valorPropiedades = 0;
                        if (propiedades.equalsIgnoreCase("si")) {
                            System.out.println("¿De qué valor son sus propiedades?");
                            valorPropiedades = scan.nextDouble();
                            scan.nextLine();
                        }

                        System.out.println("¿Por cuántos meses desea pagar el préstamo?");
                        int mesesDeseados = scan.nextInt();

                        System.out.println("¿De qué valor quiere el préstamo?");
                        double montoPrestamo = scan.nextDouble();

                        double cuotaMensualDeseada = montoPrestamo / mesesDeseados;
                        double cuotaMaximaPermitida = ingresos * 0.3;

                        if (cuotaMensualDeseada <= cuotaMaximaPermitida) {
                            Prestamo prestamoAprobado = new Prestamo(montoPrestamo, mesesDeseados, cuotaMensualDeseada);
                            cuentaPrestamo.agregarPrestamo(prestamoAprobado);
                            cuentaPrestamo.setSaldo(cuentaPrestamo.getSaldo() + montoPrestamo);
                            System.out.println("Préstamo aprobado.");
                        } else {
                            int mesesRecalculados = (int) Math.ceil(montoPrestamo / cuotaMaximaPermitida);
                            double nuevaCuota = montoPrestamo / mesesRecalculados;

                            System.out.println("El préstamo no puede aprobarse en " + mesesDeseados + " meses porque la cuota mensual sería de $" + cuotaMensualDeseada + ", lo cual excede el 30% de sus ingresos.");
                            System.out.println("La opción viable sería pagarlo en " + mesesRecalculados + " meses con una cuota mensual de $" + String.format("%.2f", nuevaCuota));
                            System.out.println("¿Desea aceptar esta nueva opción? (si/no)");
                            String acepta = scan.next();
                            scan.nextLine();

                            if (acepta.equalsIgnoreCase("si")) {
                                Prestamo prestamoAprobado = new Prestamo(montoPrestamo, mesesRecalculados, nuevaCuota);
                                cuentaPrestamo.agregarPrestamo(prestamoAprobado);
                                cuentaPrestamo.setSaldo(cuentaPrestamo.getSaldo() + montoPrestamo);
                                System.out.println("Préstamo aprobado.");
                            } else {
                                System.out.println("Préstamo cancelado.");
                            }
                        }
                        break;

                    case 7:
                        System.out.println("Ingrese su número de cuenta:");
                        String cuentaPagoPrestamo = scan.nextLine();
                        CuentaBancaria cuentaConPrestamo = buscarCuenta(cuentaPagoPrestamo);

                        if (cuentaConPrestamo == null) {
                            System.out.println("Cuenta no encontrada.");
                            break;
                        }

                        List<Prestamo> prestamos = cuentaConPrestamo.getPrestamos();

                        if (prestamos.isEmpty()) {
                            System.out.println("No hay préstamos registrados para esta cuenta.");
                            break;
                        }

                        System.out.println("Préstamos disponibles:");
                        for (int i = 0; i < prestamos.size(); i++) {
                            Prestamo p = prestamos.get(i);
                            System.out.println((i + 1) + ". " + p);
                        }

                        System.out.println("Seleccione el número del préstamo que desea pagar:");
                        int indice = scan.nextInt();
                        scan.nextLine();

                        if (indice < 1 || indice > prestamos.size()) {
                            System.out.println("Opción inválida.");
                            break;
                        }

                        Prestamo prestamoSeleccionado = prestamos.get(indice - 1);

                        if (prestamoSeleccionado.isPagado()) {
                            System.out.println("Este préstamo ya ha sido pagado.");
                            break;
                        }

                        double cuota = prestamoSeleccionado.getCuotaMensual();
                        if (cuentaConPrestamo.getSaldo() >= cuota) {
                            cuentaConPrestamo.setSaldo(cuentaConPrestamo.getSaldo() - cuota);
                            prestamoSeleccionado.marcarComoPagado();
                            cuentaConPrestamo.getHistorial().add(new Transaccion("Pago de préstamo", cuota, cuentaConPrestamo, null));
                            System.out.println("Pago de préstamo registrado con éxito.");
                        } else {
                            System.out.println("Saldo insuficiente para realizar el pago.");
                        }
                        break;

                    case 8:
                        System.out.print("Documento del usuario: ");
                        String docConsulta = scan.nextLine();
                        Persona personaConsulta = buscarPersonaPorDocumento(grafo, docConsulta);
                        if (personaConsulta != null) {
                            System.out.println("Conexiones:");
                            for (Persona conectado : personaConsulta.getConexiones()) {
                                System.out.println("- " + conectado);
                            }
                        } else {
                            System.out.println("Persona no encontrada.");
                        }
                        break;

                    case 9:
                        modificarDatosPersonales(cuenta, scan);

                    case 10:
                        System.out.println("Gracias por todo, Saliendo del programa ...... ");
                        cuenta.cerrarScanner();
                        return;

                }
                if (sesionIniciada) {
                    System.out.println("\n¿Desea realizar otra operación?(colocar numeros)");
                    System.out.println("1. si");
                    System.out.println("2. no (Cerrar sesión)");
                    int volver = scan.nextInt();
                    scan.nextLine();

                    if (volver != 1) {
                        System.out.println("Cerrando sesión...");
                        sesionIniciada = false;
                    }
                }
            }

        }
    }
}
