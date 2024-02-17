package models;

public class Administrador {
    boolean llaveADM;
    String nombre;
    int contrasena = 2308;

    public int getContrasena() {return contrasena;}
    public boolean isLlaveADM() {return llaveADM;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setLlaveADM(boolean llaveADM) {this.llaveADM = llaveADM;}
}
