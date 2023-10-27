import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class gestorGastos {

    private static String rutaGastos = System.getProperty("user.home") + "/Desktop/gastos_";

    public static void guardarGastoEnCSV(Usuario usuario, String nombreProducto, double cantidad, int categoriaSeleccionada) {
        String nombreArchivo = rutaGastos + usuario.getNombre() + ".csv";

        try {
            FileWriter archivoWriter = new FileWriter(nombreArchivo, true);
            PrintWriter escribir = new PrintWriter(archivoWriter);

            escribir.println(nombreProducto + "," + Finanzas.getCategorias()[categoriaSeleccionada - 1] + "," + cantidad);

            archivoWriter.close();
            System.out.println("Gasto registrado y guardado en el archivo CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
