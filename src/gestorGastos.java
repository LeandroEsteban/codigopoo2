import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class gestorGastos {

    private static String rutaArchivo = System.getProperty("user.dir") + File.separator + "gastos1.csv";


    public static void guardarGastoEnCSV(String nombre, double cantidad, String categoria, String nombreUsuario) {
        File archivo = new File(rutaArchivo);

        boolean existeArchivo = archivo.exists();

        try {
            FileWriter escritor = new FileWriter(rutaArchivo, true);

            if (!existeArchivo) {
                escritor.write("Nombre del Producto,Precio,Categoria,Usuario\n");
            }

            escritor.write(nombre + "," + cantidad + "," + categoria + "," + nombreUsuario + "\n");

            escritor.close();
            System.out.println("Gasto registrado en el archivo CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
