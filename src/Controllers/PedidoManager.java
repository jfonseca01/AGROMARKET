package Controllers;

import java.util.ArrayList;
import Entidades.*;



public class PedidoManager {
    // Lista para almacenar los pedidos
    private ArrayList<Pedido> pedidos;

    // Constructor
    public PedidoManager() {
        pedidos = new ArrayList<>();
    }

    // Método para crear un nuevo pedido
    public Pedido crearPedido() {
        int nuevoId = pedidos.size() + 1; // Generar un ID para el pedido
        Pedido nuevoPedido = new Pedido(nuevoId);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido creado con ID: " + nuevoId);
        return nuevoPedido;
    }

    // Método para obtener un pedido por ID
    public Pedido obtenerPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    // Método para procesar un pedido (cambiar su estado a "Procesado")
    public void procesarPedido(int id) {
        Pedido pedido = obtenerPedidoPorId(id);
        if (pedido != null && pedido.getEstado().equals("Pendiente")) {
            pedido.cambiarEstado("Procesado");
        } else {
            System.out.println("El pedido no se puede procesar. Verifique el estado o ID del pedido.");
        }
    }

    // Método para mostrar todos los pedidos
    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : pedidos) {
                pedido.mostrarInfo();
                System.out.println("------------------------");
            }
        }
    }
}
