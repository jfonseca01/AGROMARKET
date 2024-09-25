package Entidades;
import Controllers.*;
import java.util.HashMap;

public class Pedido {
    // Atributos del pedido
    private int id;
    private HashMap<Producto, Integer> productos; // Producto y cantidad
    private double total;
    private String estado;

    // Constructor
    public Pedido(int id) {
        this.id = id;
        this.productos = new HashMap<>();
        this.total = 0.0;
        this.estado = "Pendiente";
    }

    // Método para agregar un producto al pedido
    public void agregarProducto(Producto producto, int cantidad) {
        if (productos.containsKey(producto)) {
            // Si el producto ya existe en el pedido, se aumenta la cantidad
            productos.put(producto, productos.get(producto) + cantidad);
        } else {
            productos.put(producto, cantidad);
        }
        // Actualizar el total del pedido
        total += producto.getPrecio() * cantidad;
    }

    // Método para obtener el total del pedido
    public double getTotal() {
        return total;
    }

    // Método para mostrar la información del pedido
    public void mostrarInfo() {
        System.out.println("ID Pedido: " + id);
        System.out.println("Estado: " + estado);
        System.out.println("Productos en el pedido:");
        for (Producto producto : productos.keySet()) {
            int cantidad = productos.get(producto);
            System.out.println(producto.getNombre() + " - Cantidad: " + cantidad + " - Precio total: $" + (producto.getPrecio() * cantidad));
        }
        System.out.println("Total del pedido: $" + total);
    }

    // Método para cambiar el estado del pedido
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("El estado del pedido ha sido cambiado a: " + nuevoEstado);
    }

    // Método para obtener el estado del pedido
    public String getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }
}
