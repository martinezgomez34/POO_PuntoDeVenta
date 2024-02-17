package models;

import java.util.ArrayList;

public class Inventario {
    ArrayList<Producto> productos = new ArrayList<Producto>();

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Producto producto) {
        productos.add(producto);
    }

}
