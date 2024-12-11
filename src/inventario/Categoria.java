package inventario;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Categoria para organizar productos dentro de una categoria especifica.
 */
public class Categoria {
    private final int id;
    private final String nombre;
    private final List<Producto> productos;

    // Constructor
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Métodos
    public void eliminarProducto(int idProducto) {
        Producto productoAEliminar = null;
        for (Producto producto : productos) {
            if (producto.getId() == idProducto) {
                productoAEliminar = producto;
                break;
            }
        }
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado: " + productoAEliminar.getNombre());
        } else {
            System.out.println("Producto no encontrado con ID: " + idProducto);
        }
    }

    public void agregarProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(producto.getNombre())) {
                System.out.println("El producto ya existe en la categoría.");
                return;
            }
        }
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la categoria: " + nombre);
        } else {
            System.out.println("Productos en la categoria: " + nombre);
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    @Override
    public String toString() {
        return "Categoría ID: " + id + ", Nombre: " + nombre + ", Productos: " + productos.size();
    }
}
