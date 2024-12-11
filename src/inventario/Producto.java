package inventario;

/**
 * Clase Producto para representar productos en el inventario.
 * 
 * @author 14-cf2074
 */
public class Producto {
    private final int id;
    private final String nombre;
    private final String categoria;
    private final double precio;
    private int cantidad;

    // Constructor
    /**
     * Crea un nuevo producto.
     * 
     * @param id        Identificador único del producto.
     * @param nombre    Nombre del producto.
     * @param categoria Categoría del producto.
     * @param precio    Precio del producto.
     * @param cantidad  Cantidad inicial en inventario.
     * @throws IllegalArgumentException Si la cantidad inicial es negativa.
     */
    public Producto(int id, String nombre, String categoria, double precio, int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Métodos
    /**
     * Actualiza la cantidad disponible del producto.
     * 
     * @param nuevaCantidad Nueva cantidad del producto.
     * @throws IllegalArgumentException Si la nueva cantidad es negativa.
     */
    public void actualizarCantidad(int nuevaCantidad) {
        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = nuevaCantidad;
    }

    /**
     * Verifica si el stock del producto es bajo.
     * 
     * @return true si el stock es menor a 5 unidades, false en caso contrario.
     */
    public boolean verificarStockBajo() {
        return this.cantidad < 5;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", ID: " + id + ", Categoría: " + categoria
                + ", Precio: $" + precio + ", Cantidad: " + cantidad;
    }
}