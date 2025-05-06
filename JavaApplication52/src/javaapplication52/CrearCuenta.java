package javaapplication52;

import java.util.Scanner;

public class CrearCuenta {

    private String usuarioRegistrado;
    String contrasenaRegistrada;
    final Scanner scan;
    private String nombre;
    private String apellido;
    private String documento;
    private String correo;
    int edad;
    private String telefono;
    private String direccion;

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

        System.out.print("Número de documento: ");
        documento = scan.nextLine();

        System.out.print("Correo electrónico: ");
        correo = scan.nextLine();

        System.out.print("Edad: ");
        edad = Integer.parseInt(scan.nextLine());

        System.out.print("Telefono: ");
        telefono = scan.nextLine();

        System.out.print("Dirección: ");
        direccion = scan.nextLine();

        System.out.print("Nombre de usuario: ");
        usuarioRegistrado = scan.nextLine();

        System.out.print("Contraseña: ");
        contrasenaRegistrada = scan.nextLine();

        System.out.println("\nCuenta registrada exitosamente.");

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
        scan.close();
    }

}
