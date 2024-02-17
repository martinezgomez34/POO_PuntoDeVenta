import models.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Administrador administrador = new Administrador();
        Cajero cajero = new Cajero();
        Venta venta = new Venta();
        Inventario inventario = new Inventario();
        administrador.setLlaveADM(true);
        cajero.setLlaveCJ(true);
        boolean aperturaCaja = false;
        int intentos = 5;
        System.out.println("Ingresa contraseña:");
        System.out.println("_____________________");
        do {
            System.out.println("Intento " + intentos);
            int contrasena = teclado.nextInt();
            if (contrasena == administrador.getContrasena()) administrador.setLlaveADM(false);
            if (contrasena == cajero.getContrasena()) cajero.setLlaveCJ(false);
            boolean salida = true;
            if (aperturaCaja == false && cajero.isLlaveCJ() == false) {
                System.out.println("*NO HAY APERTURA DE CAJA*");
                cajero.setLlaveCJ(true);
            }
            while (cajero.isLlaveCJ() == false && salida == true && aperturaCaja == true) {
                System.out.println("_____________________");
                System.out.println("Ingresa tu nombre");
                System.out.println("_____________________");
                cajero.setNombre(teclado.next());
                do {
                    System.out.println("_____________________");
                    System.out.println("Caja 01 - cajero " + cajero.getNombre());
                    System.out.println("_____________________");
                    System.out.println("1. Registrar Venta");
                    System.out.println("2. Alta producto");
                    System.out.println("3. Consulta Producto");
                    System.out.println("4. Salir caja");
                    System.out.println("_____________________");
                    int respuesta = teclado.nextInt();
                    int respuesta2;
                    switch (respuesta) {
                        case 1:
                            System.out.println("_____________________");
                            System.out.println("Registrar Venta");
                            System.out.println("_____________________");
                            do {
                                System.out.println("ID del producto:");
                                venta.setId(teclado.nextInt());
                                System.out.println("Cantidad del producto:");
                                int cantidadRes = teclado.nextInt();
                                for (Producto item : inventario.getProductos()) {
                                    if (venta.getId() == item.getId()) {
                                        double total = item.getPrecio();
                                        total = total * cantidadRes;
                                        venta.setTotal(total);
                                        venta.setVentas(venta);
                                        int cantidad = item.getCantidad();
                                        cantidadRes = cantidad - cantidadRes;
                                        item.setCantidad(cantidadRes);
                                    }
                                }
                                System.out.println("_____________________");
                                System.out.println("Quiere agragar otro producto?");
                                System.out.println("1.SI");
                                System.out.println("2.NO");
                                System.out.println("_____________________");
                                respuesta2 = teclado.nextInt();
                            } while (respuesta2 == 1);
                            break;
                        case 2:
                            System.out.println("_____________________");
                            System.out.println("Alta Producto");
                            System.out.println("ID:");
                            int id = teclado.nextInt();
                            System.out.println("Nombre:");
                            String nombre = teclado.next();
                            System.out.println("Precio:");
                            double precio = teclado.nextInt();
                            System.out.println("Cantidad Disponibles");
                            int cantidad = teclado.nextInt();
                            Producto producto = new Producto(id, nombre, precio, cantidad);
                            inventario.setProductos(producto);
                            break;
                        case 3:
                            System.out.println("_____________________");
                            System.out.println("Consultar Inventario");
                            System.out.println("_____________________");
                            for (Producto item : inventario.getProductos()) {
                                System.out.println("ID " + item.getId());
                                System.out.println("Nombre " + item.getNombre());
                                System.out.println("Precio " + item.getPrecio());
                                System.out.println("Cantidad " + item.getCantidad());
                                System.out.println("_____________________");
                            }
                            break;
                        case 4:
                            salida = false;
                            cajero.setLlaveCJ(true);
                            System.out.println("salio de caja ----------");
                            intentos++;
                            break;
                        default:
                            System.out.println("Error, intenta de nuevo");
                            break;
                    }
                }while (salida == true);
                System.out.println("_____________________");
            }
            while (administrador.isLlaveADM() == false && salida == true) {
                System.out.println("_____________________");
                System.out.println("Administrador");
                System.out.println("_____________________");
                System.out.println("1. Arqueo de caja");
                System.out.println("2. Apertura de caja");
                System.out.println("3. Fin del programa");
                System.out.println("_____________________");
                int respuesta = teclado.nextInt();
                switch (respuesta) {
                    case 1:
                        System.out.println("_____________________");
                        for (Venta item: venta.getVentas()) {
                            System.out.println("ID producto: " + item.getId());
                            System.out.println("Total de venta: " + item.getTotal());
                            System.out.println("_____________________");
                        }
                        break;
                    case 2:
                        System.out.println("Apertura caja ---------------");
                        aperturaCaja = true;
                        administrador.setLlaveADM(true);
                        intentos++;
                        break;
                    case 3:
                        salida = false;
                        break;
                    default:
                        System.out.println("*ERROR, INTENTA DE NUEVO*");
                        break;
                }
            }
            intentos--;
        }while (intentos != 0 && administrador.isLlaveADM() == true);
        System.out.println("_____________________");
        System.out.println("Fin programa");
    }
}