package Controllers;
import Entidades.*;
import java.util.ArrayList;

public class TransaccionManager {
    // Lista para almacenar las transacciones
    private ArrayList<Transaccion> transacciones;

    // Constructor
    public TransaccionManager() {
        transacciones = new ArrayList<>();
    }

    // Método para crear una nueva transacción
    public Transaccion crearTransaccion(Pedido pedido, String metodoPago) {
        int nuevoId = transacciones.size() + 1; // Generar un ID para la transacción
        double monto = pedido.getTotal(); // Obtener el monto del pedido
        Transaccion nuevaTransaccion = new Transaccion(nuevoId, pedido, monto, metodoPago);
        transacciones.add(nuevaTransaccion);
        System.out.println("Transacción creada con ID: " + nuevoId + " para el pedido ID: " + pedido.getId());
        return nuevaTransaccion;
    }

    // Método para obtener una transacción por ID
    public Transaccion obtenerTransaccionPorId(int id) {
        for (Transaccion transaccion : transacciones) {
            if (transaccion.getId() == id) {
                return transaccion;
            }
        }
        return null;
    }

    // Método para procesar una transacción (completar el pago)
    public void procesarTransaccion(int id) {
        Transaccion transaccion = obtenerTransaccionPorId(id);
        if (transaccion != null && transaccion.getEstado().equals("Pendiente")) {
            transaccion.procesarPago();
        } else {
            System.out.println("La transacción no se puede procesar. Verifique el estado o ID de la transacción.");
        }
    }

    // Método para mostrar todas las transacciones
    public void mostrarTransacciones() {
        if (transacciones.isEmpty()) {
            System.out.println("No hay transacciones registradas.");
        } else {
            for (Transaccion transaccion : transacciones) {
                transaccion.mostrarInfo();
                System.out.println("------------------------");
            }
        }
    }
}
