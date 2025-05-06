package javaapplication52;

public class RegistroVerificado extends CrearCuenta {

    private String correoElectronico;
    private int edad;
    private String nuevaContraseña;
    private String nuevaContrasena;

    @Override
    public void registrarCuenta() {
        super.registrarCuenta();

        if (super.edad >= 18) {
            System.out.println("Edad válida para registro.");
        } else {
            System.out.println("Debe ser mayor de edad para registrar una cuenta bancaria.");
        }

        System.out.print("Ingrese una nueva contraseña para confirmar: ");
        nuevaContrasena = scan.nextLine();
        contrasenaRegistrada = nuevaContrasena;

        System.out.println("Cuenta verificada y contraseña actualizada.");
    }

    public void modificarRegistro() {
        System.out.println("Modificación de datos:");
        registrarCuenta();
    }

}
