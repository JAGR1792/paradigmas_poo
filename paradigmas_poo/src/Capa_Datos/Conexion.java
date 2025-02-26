package Capa_Datos;
import java.sql.*;

// Clase para gestionar la conexión y ejecución de sentencias SQL
public class Conexion {
    // Datos de conexión a la base de datos
    private final String url = "jdbc:mysql://localhost:3306/ventas"; // URL de la base de datos
    private final String usuario = "root"; // Usuario de la base de datos
    private final String pwd = ""; // Contraseña de la base de datos (vacía en este caso)

    // Constructor vacío
    public Conexion() {}

    // Método para ejecutar una consulta SQL que devuelva un conjunto de resultados
    public ResultSet Listar(String Cad) {
        try {
            // Establece la conexión con la base de datos
            Connection cn = DriverManager.getConnection(url, usuario, pwd);
            // Prepara la sentencia SQL
            PreparedStatement da = cn.prepareStatement(Cad);
            // Ejecuta la consulta y obtiene los resultados
            ResultSet tbl = da.executeQuery();
            return tbl;
        } catch (SQLException e) {
            // En caso de error, muestra un mensaje con el detalle
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    // Método para ejecutar una consulta SQL que modifique la base de datos
    public String Ejecutar(String Cad) {
        try {
            // Establece la conexión con la base de datos
            Connection cn = DriverManager.getConnection(url, usuario, pwd);
            // Prepara la sentencia SQL
            PreparedStatement da = cn.prepareStatement(Cad);
            // Ejecuta la actualización (INSERT, UPDATE, DELETE)
            int r = da.executeUpdate();
            // Verifica si alguna fila fue afectada por la consulta
            if (r > 0) {
                return "Se afectó " + r + " fila(s)";
            } else {
                return "No se afectó ninguna fila";
            }
        } catch (SQLException e) {
            // En caso de error, muestra un mensaje con el detalle
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
            return "Error " + e.getMessage();
        }
    }
}

}
