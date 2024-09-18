package Controllers;
import Entidades.*;
import java.util.ArrayList;

public class UsuarioManager {
    // Lista para almacenar los usuarios
    private ArrayList<Usuario> usuarios;

    // Constructor
    public UsuarioManager() {
        usuarios = new ArrayList<>();
    }

    // Método para agregar un usuario
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario agregado: " + usuario.getNombre());
    }

    // Método para obtener un usuario por ID
    public Usuario obtenerUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    // Método para eliminar un usuario por ID
    public boolean eliminarUsuario(int id) {
        Usuario usuario = obtenerUsuarioPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado: " + usuario.getNombre());
            return true;
        }
        return false;
    }

    // Método para mostrar todos los usuarios
    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : usuarios) {
                usuario.mostrarInfo();
                System.out.println("------------------------");
            }
        }
    }
}
