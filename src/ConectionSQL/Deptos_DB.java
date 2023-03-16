
package ConectionSQL;

import Model.Departamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class Deptos_DB {
    /*
    *   Sistema que administra departamentos del super
    */
    
    // Código para INSERTAR un nuevo producto en la tabla de la BD
    public void altaDepto(Departamento depto) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO DEPARTAMENTOS(CLAVE_DEPTO,NOMBRE,JEFE)"
                    + " VALUES (?,?,?)");
            pst.setString(1, depto.getClaveDepto());
            pst.setString(2, depto.getNombre());
            pst.setString(3, depto.getJefe());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al agregar datos en la tabla");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
    // Código para VER la tabla de la BD
    public ArrayList<Departamento> consultarDeptos() {
        ArrayList<Departamento> deptos = new ArrayList();
        Connection cnx = DataBaseConexion.getConnection();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT CLAVE_DEPTO,NOMBRE,JEFE"
                    + " FROM DEPARTAMENTOS ORDER BY 1 ");
            while (rs.next()) {
                Departamento depto = new Departamento();
                depto.setClaveDepto(rs.getString("CLAVE_DEPTO"));
                depto.setNombre(rs.getString("NOMBRE"));
                depto.setJefe(rs.getString("JEFE"));
                deptos.add(depto);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al obtener los datos de la tabla");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
        return deptos;
    }
    
    // Código para utilizar el Procedimiento almacenado de Oracle PL/SQL (BAJA_PRODUCTO)
    public void bajaDepto(String clave_depto) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada al pocedimiento de la BD
            CallableStatement cst = cnx.prepareCall("{call BAJA_DEPTO (?)}");
            
            // Parametro para el procedimiento almacenado
            cst.setString(1, clave_depto);
            
            // Ejecuta el procedimiento almacenado
            cst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al eliminar el registro de la tabla");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
    // Código para BUSCAR un producto en la tabla de la BD
    public boolean regresaDepto(String clave_depto) {
        Connection cnx = DataBaseConexion.getConnection();
        Departamento depto = new Departamento();
        boolean ban = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_DEPTO,NOMBRE,JEFE"
                    + " FROM DEPARTAMENTOS WHERE CLAVE_DEPTO like (?)");
            pst.setString(1, clave_depto);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                depto.setClaveDepto("CLAVE_DEPTO");
                depto.setNombre(rs.getString("NOMBRE"));
                depto.setJefe(rs.getString("JEFE"));
                ban = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al mostrar el departamento");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
        return ban;
    }
}
