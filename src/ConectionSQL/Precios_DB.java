
package ConectionSQL;

import Model.Asignacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class Precios_DB {
    /*
    *   Sistema que administra los precios de los produtos del super
    */
    
    // Código para VER los precios de los productos en un departamento
    public ArrayList<Asignacion> consultarProductos(String clave_depto) {
        Connection cnx = DataBaseConexion.getConnection();
        ArrayList<Asignacion> asignaciones = new ArrayList();
        Asignacion asignacion = new Asignacion();
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_PROD,PRECIO"
                    + " FROM ASIG_PROD WHERE CLAVE_DEPTO like (?)");
            pst.setString(1, clave_depto);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                asignacion.setClaveProd(rs.getInt("CLAVE_PROD"));
                asignacion.setPrecio(Double.parseDouble(rs.getString("PRECIO")));
                asignaciones.add(asignacion);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al mostrar el producto");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return asignaciones;
    }
    
    // Código para utilizar el Procedimiento almacenado de Oracle PL/SQL (ACTUALIZA_PRECIO)
    public void actualizaPrecio(double precio_nuevo, int clave_prod, String clave_depto) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada al pocedimiento de la BD
            CallableStatement cst = cnx.prepareCall("{call ACTUALIZA_PRECIO (?,?,?)}");
            
            // Parametro 1 para el procedimiento almacenado
            cst.setDouble(1, precio_nuevo);
            // Parametro 2 para el procedimiento almacenado
            cst.setInt(2, clave_prod);
            // Parametro 3 para el procedimiento almacenado
            cst.setString(3, clave_depto);
            
            // Ejecuta el procedimiento almacenado
            cst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al actualizar datos de la tabla");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
}
