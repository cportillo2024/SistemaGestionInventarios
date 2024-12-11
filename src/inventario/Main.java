package inventario;

import java.util.Scanner;

/**
 * Clase principal para gestionar el sistema de inventarios.
 * 
 * @author 14-cf2074
 */
public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        // Menú Interactivo
        while (true) {
            System.out.println("\n--- Sistema de Gestion de Inventarios ---");
            System.out.println("1. Agregar Categoria");
            System.out.println("2. Listar Categorias");
            System.out.println("3. Agregar Producto a Categoria");
            System.out.println("4. Listar Productos en una Categoria");
            System.out.println("5. Eliminar Categoria o Producto");
            System.out.println("6. Verificar Productos con Stock Bajo");
            System.out.println("7. Salir");
            System.out.print("Elige una opcion: ");
            
            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } catch (Exception e) {
                System.out.println("Entrada invalida. Por favor, ingresa un numero.");
                scanner.nextLine(); // Limpiar el buffer
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre de la nueva categoria: ");
                    String nombreCategoria = scanner.nextLine();
                    Categoria nuevaCategoria = new Categoria(inventario.getCantidadCategorias() + 1, nombreCategoria);
                    inventario.agregarCategoria(nuevaCategoria);
                }
                case 2 -> inventario.listarCategorias();
                case 3 -> {
                    System.out.print("Nombre de la categoria: ");
                    String nombreCat = scanner.nextLine();
                    Categoria categoria = inventario.buscarCategoriaPorNombre(nombreCat);
                    if (categoria != null) {
                        try {
                            System.out.print("ID del producto: ");
                            int idProducto = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            System.out.print("Nombre del producto: ");
                            String nombreProducto = scanner.nextLine();
                            System.out.print("Precio del producto: ");
                            double precioProducto = scanner.nextDouble();
                            System.out.print("Cantidad del producto: ");
                            int cantidadProducto = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            Producto nuevoProducto = new Producto(idProducto, nombreProducto, nombreCat, precioProducto, cantidadProducto);
                            categoria.agregarProducto(nuevoProducto);
                        } catch (Exception e) {
                            System.out.println("Error en los datos ingresados. Por favor, verifica e intenta nuevamente.");
                            scanner.nextLine(); // Limpiar el buffer
                        }
                    } else {
                        System.out.println("Categoria no encontrada.");
                    }
                }
                case 4 -> {
                    System.out.print("Nombre de la categoria: ");
                    String nombreCatListado = scanner.nextLine();
                    Categoria categoriaListado = inventario.buscarCategoriaPorNombre(nombreCatListado);
                    if (categoriaListado != null) {
                        categoriaListado.listarProductos();
                    } else {
                        System.out.println("Categoria no encontrada.");
                    }
                }
                case 5 -> {
                    System.out.println("1. Eliminar Categoria");
                    System.out.println("2. Eliminar Producto");
                    System.out.print("Elige una opcion: ");
                    int subOpcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                switch (subOpcion) {
                    case 1 -> {
                        System.out.print("Nombre de la categoria a eliminar: ");
                        String nombreCatEliminar = scanner.nextLine();
                        inventario.eliminarCategoria(nombreCatEliminar);
                    }
                    case 2 -> {
                        System.out.print("Nombre de la categoria del producto: ");
                        String nombreCatProducto = scanner.nextLine();
                        Categoria categoria = inventario.buscarCategoriaPorNombre(nombreCatProducto);
                        if (categoria != null) {
                            System.out.print("ID del producto a eliminar: ");
                            int idProductoEliminar = scanner.nextInt();
                            scanner.nextLine(); // Limpiar buffer
                            categoria.eliminarProducto(idProductoEliminar);
                        } else {
                            System.out.println("No se encontro la categoria ingresada. Verifica el nombre.");
                        }
                    }
                    default -> System.out.println("Opcion no valida.");
                }
                }
                case 6 -> inventario.verificarStockBajoEnCategorias();
                case 7 -> {
                    System.out.println("¡Gracias por usar el sistema de gestion de inventarios!");
                    return;
                }
                default -> System.out.println("Opcion no valida. Por favor, intenta nuevamente.");
            }
        }
    }
}