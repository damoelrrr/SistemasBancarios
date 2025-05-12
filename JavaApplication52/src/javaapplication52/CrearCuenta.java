package javaapplication52;

import java.util.Random;
import java.util.Scanner;

public class CrearCuenta {

    String usuarioRegistrado;
    String contrasenaRegistrada;
    final Scanner scan;
    String nombre;
    String apellido;
    String documento;
    String correo;
    int edad;
    private String telefono;
    String direccion;
    double monto;
    int numeroCuenta;

    public CrearCuenta(String usuarioRegistrado, String contrasenaRegistrada, Scanner scan) {
        this.usuarioRegistrado = usuarioRegistrado;
        this.contrasenaRegistrada = contrasenaRegistrada;
        this.scan = scan;
    }

    public Scanner getScanner() {
        return scan;
    }

    public CrearCuenta() {
        scan = new Scanner(System.in);
    }

    public void registrarCuenta() {

        System.out.println("Por favor, completa el formulario de registro.");

        System.out.print("Nombres: ");
        nombre = scan.nextLine();

        System.out.println("Apellidos:");
        apellido = scan.nextLine();

        System.out.print("Edad: ");
        edad = Integer.parseInt(scan.nextLine());

        System.out.print("Número de documento: ");
        documento = scan.nextLine();

        System.out.print("Correo electrónico: ");
        correo = scan.nextLine();

        System.out.print("Telefono: ");
        telefono = scan.nextLine();
        if (!telefono.matches("\\d{10}")) {
            System.out.println("El numero de telefono debe tener exactamente 10 dígitos y ser numerico.");
            System.exit(0);

            return;
        }

        System.out.print("Dirección: ");
        direccion = scan.nextLine();

        System.out.print("Nombre de usuario: ");
        usuarioRegistrado = scan.nextLine();

        System.out.print("Contraseña: ");
        contrasenaRegistrada = scan.nextLine();

        System.out.println("Ingresa mínimo (2.000 pesos) para poder crear la cuenta");

        try {
            monto = scan.nextDouble();
            scan.nextLine();
            if (monto < 2000) {
                System.out.println("Monto insuficiente");
                System.exit(0);

                return;
            }
        } catch (Exception e) {
            System.out.println("Error: entrada inválida para el monto.");
            scan.nextLine();
            return;
        }
        System.out.println("\nCuenta registrada exitosamente.");
        Random rand = new Random();
        Persona persona = new Persona(nombre, apellido, edad, documento, correo, telefono, direccion);
        String numCuentaStr = String.valueOf(100000 + new Random().nextInt(900000));
        CuentaBancaria cuentaNueva = new CuentaBancaria(numCuentaStr, persona, monto);
        System.out.println("Su número de cuenta es: " + numCuentaStr);

//        guardarDatosEnArchivo();
    }

    public boolean iniciarSesion() {
        if (usuarioRegistrado == null && contrasenaRegistrada == null) {
            System.out.println("Error ");
            return false;
        }
        System.out.println("Iniciar sesion.");
        String usuarioIngresado;
        String contrasenaIngresada;
        int intentos = 0;

        do {
            System.out.print("Ingresa tu nombre de usuario: ");
            usuarioIngresado = scan.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            contrasenaIngresada = scan.nextLine();

            if (usuarioRegistrado.equals(usuarioIngresado) && contrasenaRegistrada.equals(contrasenaIngresada)) {
                System.out.println("Acceso exitoso. Bienvenido a tu cuenta bancaria.");
                return true;
            } else {
                intentos++;
                if (intentos >= 5) {
                    System.out.println("Has alcanzado el número máximo de intentos. El programa se cerrará.");
                    return false;
                }
                System.out.println("Datos incorrectos. Intenta de nuevo.");
            }

        } while (true);
    }

//    private void guardarDatosEnArchivo() {
//        try (FileWriter escritor = new FileWriter("cuentas.txt", true)) {
//            escritor.write("Usuario: " + usuarioRegistrado + "\n");
//            escritor.write("Contraseña: " + contrasenaRegistrada + "\n");
//            escritor.write("Nombre: " + nombre + " " + apellido + "\n");
//            escritor.write("Documento: " + documento + "\n");
//            escritor.write("Correo: " + correo + "\n");
//            escritor.write("Edad: " + edad + "\n");
//            escritor.write("Teléfono: " + telefono + "\n");
//            escritor.write("Dirección: " + direccion + "\n");
//            escritor.write("-----\n");
//        } catch (IOException e) {
//            System.out.println("Error al guardar los datos: " + e.getMessage());
//        }
//    }
    public void cerrarScanner() {
        System.out.println("Finalizando programa. Gracias por usar nuestros servicios.");
        scan.close();
    }

    public void cerrarPrincipio() {
        scan.close();
    }

}
