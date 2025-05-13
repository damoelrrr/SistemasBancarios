
package javaapplication52;


import java.util.Date;

public class Prestamo {
    private double monto;
    private int meses;
    private double cuotaMensual;
    private Date fecha;
    private boolean pagado;

    public Prestamo(double monto, int meses, double cuotaMensual) {
        this.monto = monto;
        this.meses = meses;
        this.cuotaMensual = cuotaMensual;
        this.fecha = new Date();
        this.pagado = false;
    }

    public double getMonto() {
        return monto;
    }

    public int getMeses() {
        return meses;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void marcarComoPagado() {
        this.pagado = true;
    }

    @Override
    public String toString() {
        return "Préstamo de $" + monto + " a " + meses + " meses. Cuota mensual: $" + cuotaMensual + ". Fecha: " + fecha + ". Pagado: " + pagado;
    }
}
