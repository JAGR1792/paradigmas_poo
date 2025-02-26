package Capa_Negocio;

import java.util.ArrayList;
import java.sql.*;
import Capa_Datos.Conexion;

// Clase que representa el negocio relacionado con los artículos
public class DataArticulo {
    // Atributos de la clase Artículo
    private String art_cod;
    private String art_nom;
    private String art_uni;
    private double art_pre;
    private int art_stk;
    private String art_marca;

    // Método para eliminar un artículo por su código
    public String EliminarArticulo() {
        Conexion objmod = new Conexion();
        // Sentencia SQL para eliminar el artículo
        String cad = "delete from articulo where art_cod ='" + this.getArt_cod() + "'";
        return objmod.Ejecutar(cad);
    }

    // Método para insertar un nuevo artículo en la base de datos
    public String GrabarArticulo() {
        Conexion objmod = new Conexion();
        // Sentencia SQL para insertar el artículo
        String cad = "Insert into articulo values('" + this.getArt_cod()
                + "','" + this.getArt_nom() + "','" + this.getArt_uni() + "','"
                + this.getArt_pre() + "','" + this.getArt_stk() + "','"
                + this.getArt_marca() + "')";
        return objmod.Ejecutar(cad);
    }

    // Método para actualizar los datos de un artículo existente
    public String EditarArticulo() {
        Conexion objmod = new Conexion();
        // Sentencia SQL para actualizar el artículo
        String cad = "Update articulo set art_nom ='" + this.getArt_nom()
                + "',art_uni ='" + this.getArt_uni() + "',art_pre ='" + this.getArt_pre()
                + "',art_stk ='" + this.getArt_stk() + "',art_marca ='" + this.getArt_marca()
                + "' where art_cod ='" + this.getArt_cod() + "'";
        return objmod.Ejecutar(cad);
    }

    // Método para obtener una lista de todos los artículos en la base de datos
    public ArrayList<DataArticulo> ListaArticulos() {
        // Crea una lista para almacenar los artículos
        ArrayList lista2 = new ArrayList();
        try {
            Conexion objmod = new Conexion();
            // Ejecuta la consulta SQL para obtener todos los artículos
            ResultSet tabla = objmod.Listar("select * from articulo");
            DataArticulo onjart;
            // Recorre el resultado de la consulta y llena la lista
            while (tabla.next()) {
                onjart = new DataArticulo();
                // Asigna los valores de la base de datos a un objeto artículo
                onjart.setArt_cod(tabla.getString("art_cod"));
                onjart.setArt_nom(tabla.getString("art_nom"));
                onjart.setArt_uni(tabla.getString("art_uni"));
                onjart.setArt_pre(tabla.getDouble("art_pre"));
                onjart.setArt_stk(tabla.getInt("art_stk"));
                onjart.setArt_marca(tabla.getString("art_marca"));
                // Añade el objeto artículo a la lista
                lista2.add(onjart);
            }
        } catch (SQLException e) {
            // En caso de error, muestra un mensaje con el detalle
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista2; // Retorna la lista de artículos
    }

    // Métodos getters y setters para los atributos del artículo

    public String getArt_cod() {
        return art_cod;
    }

    public void setArt_cod(String art_cod) {
        this.art_cod = art_cod;
    }

    public String getArt_nom() {
        return art_nom;
    }

    public void setArt_nom(String art_nom) {
        this.art_nom = art_nom;
    }

    public String getArt_uni() {
        return art_uni;
    }

    public void setArt_uni(String art_uni) {
        this.art_uni = art_uni;
    }

    public double getArt_pre() {
        return art_pre;
    }

    public void setArt_pre(double art_pre) {
        this.art_pre = art_pre;
    }

    public int getArt_stk() {
        return art_stk;
    }

    public void setArt_stk(int art_stk) {
        this.art_stk = art_stk;
    }

    public String getArt_marca() {
        return art_marca;
    }

    public void setArt_marca(String art_marca) {
        this.art_marca = art_marca;
    }
}
