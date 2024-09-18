package Controllers;
import Entidades.*;
import java.util.ArrayList;


public class ProductoManager {
    // Lista para almacenar los productos
    private ArrayList<Producto> productos;

    // Constructor
    public ProductoManager() {
        productos = new ArrayList<>();
    }

    // Método para agregar un producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    // Método para obtener un producto por ID
    public Producto obtenerProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    // Método para eliminar un producto por ID
    public boolean eliminarProducto(int id) {
        Producto producto = obtenerProductoPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + producto.getNombre());
            return true;
        }
        return false;
    }

    // Método para mostrar todos los productos
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : productos) {
                producto.mostrarInfo();
                System.out.println("------------------------");
            }
        }
    }
}
