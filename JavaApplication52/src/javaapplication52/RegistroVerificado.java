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

        if (super.edad >= 18) {
            System.out.println("Edad válida para registro.");
        } else {
            System.out.println("Debe ser mayor de edad para registrar una cuenta bancaria.");
        }
        telefono = obtenerTelefono();

    }

    private String obtenerTelefono() {
        

        String telefono;
        
                System.out.println("El número de teléfono debe tener exactamente 10 dígitos y ser numérico.");
            
        return null;
    }

    public void CambiarContraseña() {
        System.out.println("Ingrese su edad");
        System.out.print("Ingrese su nueva contraseña: ");
        nuevaContraseña = scan.nextLine();

     if(contrasenaRegistrada == nuevaContraseña){
         
    }else if (nuevaContraseña != null && !nuevaContraseña.trim().isEmpty()) {
            contrasenaRegistrada = nuevaContraseña;
            System.out.println("Contraseña actualizada correctamente.");
        } else {
            System.out.println("La contraseña no puede ser vacía.");
        }
    }

    public void modificarRegistro() {
        System.out.println("Modificación de datos:");
        registrarCuenta();
    }

}
