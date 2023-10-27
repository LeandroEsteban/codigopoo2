import java.util.ArrayList;

public class Finanzas {

    private static int numCategorias = 5;
    private static String[] categorias = new String[numCategorias];
    private static ArrayList<String>[] productosPorCategoria = new ArrayList[numCategorias];
    private static ValidarEntradaUsuario validador = new ValidarEntradaUsuario();

    public static void main(String[] args) {
        // Crear una instancia de la Calculadora
        Calculadora calculadora = new Calculadora();

        // Inicializar las categorías y productos (asegúrate de hacerlo antes de usarlos)
        inicializarCategorias();

        // Crear una instancia de la clase Usuario e iniciar sesión
        Usuario usuario = Usuario.iniciarSesion();

        // Verificar si la autenticación fue exitosa
        if (usuario != null) {
            // Crear una instancia de Menu y pasar las categorías y productos
            Menu menu = new Menu(categorias, productosPorCategoria);

            // Ejecutar el menú con el usuario autenticado y el menú
            ejecutarMenu(usuario, menu, calculadora);
        } else {
            System.out.println("No se pudo iniciar sesión. Saliendo del programa.");
        }
    }
    private static void inicializarCategorias() {
        categorias[0] = "Alimentación";
        categorias[1] = "Transporte";
        categorias[2] = "Entretenimiento";
        categorias[3] = "Educación";
        categorias[4] = "Otras";

        for (int i = 0; i < numCategorias; i++) {
            productosPorCategoria[i] = new ArrayList<>();
        }
    }

    public static String[] getCategorias() {
        return categorias;
    }

    public static ArrayList<String>[] getProductosPorCategoria() {
        return productosPorCategoria;
    }
    public static void ejecutarMenu(Usuario usuario, Menu menu, Calculadora calculadora) {
        while (true) {
            menu.mostrarMenu(calculadora.getSaldoActual());
            int opcion = validador.validarInt();
            switch (opcion) {
                case 1:
                    calculadora.anadirDinero();
                    break;
                case 2:
                    calculadora.restarDinero();
                    break;
                case 3:
                    calculadora.mostrarGastosPorCategoria();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }

}