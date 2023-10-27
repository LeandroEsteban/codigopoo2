import java.util.Scanner;

public class InicioUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al Sistema de Usuarios");
            System.out.println("Opciones:");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Crear Cuenta");
            System.out.println("3. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    Usuario usuario = Usuario.iniciarSesion();
                    if (usuario != null) {
                        System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario.getNombre() + "!");
                        GestorCategorias.inicializarCategorias();
                        Menu menu = new Menu(Finanzas.getCategorias(), Finanzas.getProductosPorCategoria());
                        Calculadora calculadora = new Calculadora();
                        Finanzas.ejecutarMenu(usuario, menu, calculadora);
                    }
                    break;
                case 2:
                    crearCuenta();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
    public static void crearCuenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();


        String correo;
        do {
            System.out.print("Ingresa tu correo electrónico: ");
            correo = scanner.nextLine();

            if (!Usuario.validarFormatoCorreo(correo)) {
                System.out.println("El formato del correo electrónico no es válido. Por favor, inténtalo de nuevo.");
            } else if (Usuario.correoExiste(correo)) {
                System.out.println("Correo ya en uso. Usa otro.");
            }
        } while (!Usuario.validarFormatoCorreo(correo) || Usuario.correoExiste(correo));


        System.out.print("Ingresa tu contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.println("¿Desea continuar con la creación de la cuenta? (s/n)");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("s")) {
            Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
            Usuario.guardarUsuario(nuevoUsuario);
            System.out.println("¡Cuenta creada exitosamente!");
        } else {
            System.out.println("Creación de cuenta cancelada.");
        }
    }
}