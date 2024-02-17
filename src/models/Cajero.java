package models;

public class Cajero {
    boolean llaveCJ;
    String nombre;
    int contrasena = 1234;

    public int getContrasena() {return contrasena;}

    public String getNombre() {return nombre;}

    public boolean isLlaveCJ() {return llaveCJ;}

    public void setLlaveCJ(boolean llaveCJ) {this.llaveCJ = llaveCJ;}

    public void setNombre(String nombre) {this.nombre = nombre;}
}
