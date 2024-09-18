import Controllers.*;
import Entidades.*;

public class App {
    public static void main(String[] args) {
        // Crear el gestor de productos, pedidos y transacciones
        ProductoManager productoManager = new ProductoManager();
        PedidoManager pedidoManager = new PedidoManager();
        TransaccionManager transaccionManager = new TransaccionManager();

        // Crear algunos productos
        Producto producto1 = new Producto(1, "Manzanas", 1.5, 100);
        Producto producto2 = new Producto(2, "Peras", 2.0, 50);

        // Agregar productos al sistema
        productoManager.agregarProducto(producto1);
        productoManager.agregarProducto(producto2);

        // Crear un nuevo pedido
        Pedido pedido = pedidoManager.crearPedido();
        pedido.agregarProducto(producto1, 10);
        pedido.agregarProducto(producto2, 5);
        pedido.mostrarInfo();

        // Crear una nueva transacción para el pedido
        Transaccion transaccion = transaccionManager.crearTransaccion(pedido, "Tarjeta de crédito");

        // Mostrar las transacciones registradas
        transaccionManager.mostrarTransacciones();

        // Procesar la transacción (completar el pago)
        transaccionManager.procesarTransaccion(transaccion.getId());

        // Mostrar las transacciones después de procesar el pago
        transaccionManager.mostrarTransacciones();
    }
}
