package Entidades;
import Controllers.*;

public class Transaccion {
    // Atributos de la transacción
    private int id;
    private Pedido pedido;
    private double monto;
    private String metodoPago;
    private String estado;

    // Constructor
    public Transaccion(int id, Pedido pedido, double monto, String metodoPago) {
        this.id = id;
        this.pedido = pedido;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = "Pendiente";
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double getMonto() {
        return monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para mostrar la información de la transacción
    public void mostrarInfo() {
        System.out.println("ID Transacción: " + id);
        System.out.println("Pedido ID: " + pedido.getId());
        System.out.println("Monto: $" + monto);
        System.out.println("Método de pago: " + metodoPago);
        System.out.println("Estado: " + estado);
    }

    // Método para cambiar el estado de la transacción
    public void procesarPago() {
        if (this.estado.equals("Pendiente")) {
            this.estado = "Completado";
            System.out.println("Pago completado para la transacción ID: " + id);
        } else {
            System.out.println("La transacción ya fue procesada.");
        }
    }
}
