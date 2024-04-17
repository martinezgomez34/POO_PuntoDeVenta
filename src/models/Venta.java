package models;

import java.util.ArrayList;

public class Venta {
    ArrayList<Venta> ventas = new ArrayList<>();
    int id;
    String cantidadP;
    String fecha;
    double total;

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public boolean setVentas(Venta venta) {
        boolean status = ventas.add(venta);
        return status;
    }

    public int getId() {
        return id;
    }
    public String getFecha() {
        return fecha;
    }
    public double getTotal() {
        return total;
    }

    public String getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(String cantidadP) {
        this.cantidadP = cantidadP;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

}
