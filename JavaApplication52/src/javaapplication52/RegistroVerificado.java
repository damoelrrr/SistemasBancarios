package javaapplication52;

public class RegistroVerificado extends CrearCuenta {

    private String correoElectronico;
    private int edad;
    private String nuevaContraseña;
    private String nuevaContrasena;
    private String telefono;

    @Override
    public void registrarCuenta() {
        super.registrarCuenta();
        try{
        edad = Integer.parseInt(scan.nextLine());
            if (super.edad >= 18) {

            } else {
                System.out.println("Debe ser mayor de edad para registrar una cuenta bancaria.");
            }
        }catch(NumberFormatException e){
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
        System.out.println("Modificación de datos:");
        System.out.println("¿Qué información te gustaría modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Correo");
        System.out.println("4. Teléfono");
        System.out.println("5. Dirección");
        System.out.print("Selecciona una opción: ");
        int modificar = scan.nextInt();
        scan.nextLine();
        switch (modificar) {
            case 1:
                System.out.print("Ingresa el nuevo nombre: ");
                nombre = scan.nextLine();
                break;
            case 2:
                System.out.print("Ingresa el nuevo apellido: ");
                apellido = scan.nextLine();
                break;
            case 3:
                System.out.print("Ingresa el nuevo correo: ");
                correo = scan.nextLine();
                break;
            case 4:
                telefono = obtenerTelefono();
                break;
            case 5:
                System.out.print("Ingresa la nueva dirección: ");
                direccion = scan.nextLine();
                break;

            default:
                System.out.println("Opción no válida.");
                break;
        }

        System.out.println("Información modificada correctamente.");

    }
}
