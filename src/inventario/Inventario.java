package inventario;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Inventario para gestionar las categorias y productos.
 * 
 * @author 14-cf2074
 */
public class Inventario {
    private final List<Categoria> categorias;

    // Constructor
    public Inventario() {
        this.categorias = new ArrayList<>();
    }

    // Métodos
    /**
     * Agrega una nueva categoría al inventario.
     * 
     * @param categoria La categoría a agregar.
     */
    public void agregarCategoria(Categoria categoria) {
        for (Categoria cat : categorias) {
            if (cat.getNombre().equalsIgnoreCase(categoria.getNombre())) {
                System.out.println("La categoria ya existe: " + categoria.getNombre());
                return;
            }
        }
        categorias.add(categoria);
        System.out.println("Categoria agregada: " + categoria.getNombre());
    }

    /**
     * Lista todas las categorías registradas en el inventario.
     */
    public void listarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorias registradas.");
            return;
        }
        System.out.println("Categorias en el inventario:");
        for (Categoria categoria : categorias) {
            System.out.println(categoria);
        }
    }

    /**
     * Busca una categoría por su nombre.
     * 
     * @param nombre Nombre de la categoría a buscar.
     * @return La categoría encontrada o null si no existe.
     */
    public Categoria buscarCategoriaPorNombre(String nombre) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                return categoria;
            }
        }
        System.out.println("Categoria no encontrada: " + nombre);
        return null;
    }

    /**
     * Obtiene la cantidad de categorías en el inventario.
     * 
     * @return Número total de categorías.
     */
    public int getCantidadCategorias() {
        return categorias.size();
    }

    /**
     * Verifica si hay productos con bajo stock en las categorías y los lista.
     */
    public void verificarStockBajoEnCategorias() {
        boolean hayStockBajo = false;
        for (Categoria categoria : categorias) {
            System.out.println("Verificando stock en categoria: " + categoria.getNombre());
            for (Producto producto : categoria.getProductos()) {
                if (producto.verificarStockBajo()) {
                    System.out.println("Stock bajo -> Producto: " + producto.getNombre() + " (Cantidad: " + producto.getCantidad() + ")");
                    hayStockBajo = true;
                }
            }
        }
        if (!hayStockBajo) {
            System.out.println("No se encontraron productos con stock bajo.");
        }
    }

    /**
     * Elimina una categoría por su nombre. Si existe, la elimina junto con sus productos.
     * 
     * @param nombreCatEliminar Nombre de la categoría a eliminar.
     */
    public void eliminarCategoria(String nombreCatEliminar) {
        Categoria categoriaAEliminar = null;
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombreCatEliminar)) {
                categoriaAEliminar = categoria;
                break;
            }
        }
        if (categoriaAEliminar != null) {
            categorias.remove(categoriaAEliminar);
            System.out.println("Categoria eliminada: " + categoriaAEliminar.getNombre());
        } else {
            System.out.println("Categoria no encontrada: " + nombreCatEliminar);
        }
    }
}