package javaapplication52;

import javaapplication52.CrearCuenta;

public class RegistroVerificado extends CrearCuenta {

    private String correoElectronico;
    private int edad;
    private String nuevaContraseña;
    private String nuevaContrasena;
    private String telefono;

    @Override
    public void registrarCuenta() {
        super.registrarCuenta();
        try {

            if (super.edad >= 18) {

            } else {
                System.out.println("Debe ser mayor de edad para registrar una cuenta bancaria.");
                cerrarPrincipio(); // Aquí cerramos el Scanner si la edad no es válida
            return;
                
            }
        } catch (NumberFormatException e) {
            System.out.println("Numero no valido");
            return;
        }

        telefono = obtenerTelefono();

    }

    private String obtenerTelefono() {

        String telefono;

        System.out.println("El número de teléfono debe tener exactamente 10 dígitos y ser numérico.");

        return null;
    }

    public void cambiarContraseña() {
        System.out.println("Ingrese su edad");
        System.out.print("Ingrese su nueva contraseña: ");
        nuevaContraseña = scan.nextLine();

        if (contrasenaRegistrada.equals(nuevaContraseña)) {
            System.out.println("La nueva contraseña no puede ser igual a la anterior.");
        } else if (nuevaContraseña != null && !nuevaContraseña.trim().isEmpty()) {
            contrasenaRegistrada = nuevaContraseña;
            System.out.println("Contraseña actualizada correctamente.");
        } else {
            System.out.println("La contraseña no puede ser vacía.");
        }
    }

    public void modificarRegistro() {
        boolean continuar = true;
        System.out.println("Modificación de datos:");
        System.out.println("¿Qué información te gustaría modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Correo");
        System.out.println("4. Teléfono");
        System.out.println("5. Dirección");
        System.out.println("6. Eliminar Cuenta");
        System.out.print("Selecciona una opción: ");
        int modificar = scan.nextInt();
        scan.nextLine();
        switch (modificar) {
            case 1:
                nombre = leerCampoObligatorio("Nuevo nombre: ");

                break;
            case 2:
                apellido = leerCampoObligatorio("Nuevo apellido: ");

                break;
            case 3:
                correo = leerCorreoValido();

                break;
            case 4:
                telefono = obtenerTelefono();
                break;
            case 5:
                System.out.print("Ingresa la nueva direccion: ");
                direccion = leerCampoObligatorio("Nueva direccion: ");
                break;
            case 6:
//                if (//algonose > 0) {
//                    System.out.println("No puede eliminar su cuenta mientras tenga saldo disponible.");
//                    return;

                    System.out.println("Eliminar Cuenta");
                    System.out.println("Desea usted eliminar la cuenta(si/no)");
                    String cuenta = scan.nextLine();
                    if (cuenta.equalsIgnoreCase("si")) {
                        usuarioRegistrado = null;
                        nombre = null;
                        apellido = null;
                        documento = null;
                        correo = null;
                        edad = 0;
                        telefono = null;
                        direccion = null;
                        contrasenaRegistrada = null;

                        System.out.println("Su cuenta ha sido eliminada exitosamente.");
                    } else if (cuenta.equalsIgnoreCase("no")) {
                        //inicio pero tiene que volver al principio
                        System.out.println("En realizacion");
                    } else {
                        System.out.println("Opción no valida.");
                    }

                
                default:
                System.out.println("Opcion no valida.");
                break;
        }

        System.out.println("Informacion modificada correctamente.");

        }

    

    private String leerCampoObligatorio(String nuevo_nombre_) {
        String entrada;
        do {
            System.out.print(nuevo_nombre_);
            entrada = scan.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("Este campo no puede estar vacío.");
        } while (true);
    }

    private String leerCorreoValido() {
        String correo;
        do {
            System.out.print("Nuevo correo: ");
            correo = scan.nextLine();
            if (correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                return correo;
            }
            System.out.println("Correo electrónico invalido. Intenta nuevamente.");
        } while (true);
    }
}
