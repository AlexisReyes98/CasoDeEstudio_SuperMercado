
package ConectionSQL;

import Model.Producto;
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
public class Productos_DB {
    /*
    *   Sistema que administra los productos del super
    */
    
    // Código para INSERTAR un nuevo producto en la tabla de la BD
    public void altaProducto(Producto prod) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO PRODUCTOS(CLAVE_PROD,NOMBRE,PROVEEDOR)"
                    + " VALUES (?,?,?)");
            pst.setInt(1, prod.getClaveProd());
            pst.setString(2, prod.getNombre());
            pst.setString(3, prod.getProveedor());
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
    
    // Código para generar una nueva clave del producto
    public int generaClaveProd() {
        int clave = 0;
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada a la funcion de la BD
            CallableStatement cst = cnx.prepareCall("{? = call CLAVE_MAYOR (?)}");
            
            // Se indica que el primer interrogante es de salida
            cst.registerOutParameter(1, java.sql.Types.INTEGER);
            
            // Se pasa un parámetro en el segundo interrogante
            cst.setInt(2, 0);
            
            // Ejecuta la función almacenada
            cst.executeUpdate();
            
            // Se recupera el resultado de la funcion pl/sql
            clave = cst.getInt(1);
            clave = clave + 1;
        } catch (SQLException ex) {
            clave = 1;
            System.out.println(ex.getMessage());
            System.out.println("Error al obtener la clave mayor o no hay regristros");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        
        return clave;
    }
    
    // Código para VER la tabla de la BD
    public ArrayList<Producto> consultarProductos() {
        ArrayList<Producto> productos = new ArrayList();
        Connection cnx = DataBaseConexion.getConnection();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery("SELECT CLAVE_PROD,NOMBRE,PROVEEDOR"
                    + " FROM PRODUCTOS ORDER BY 1 ");
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setClaveProd(rs.getInt("CLAVE_PROD"));
                prod.setNombre(rs.getString("NOMBRE"));
                prod.setProveedor(rs.getString("PROVEEDOR"));
                productos.add(prod);
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
        
        return productos;
    }
    
    // Código para utilizar el Procedimiento almacenado de Oracle PL/SQL (BAJA_PRODUCTO)
    public void bajaProducto(int clave_producto) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada al pocedimiento de la BD
            CallableStatement cst = cnx.prepareCall("{call BAJA_PRODUCTO (?)}");
            
            // Parametro para el procedimiento almacenado
            cst.setInt(1, clave_producto);
            
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
    public boolean buscaProducto(int clave_prod) {
        Connection cnx = DataBaseConexion.getConnection();
        Producto prod = new Producto();
        boolean ban = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_PROD,NOMBRE,PROVEEDOR"
                    + " FROM PRODUCTOS WHERE CLAVE_PROD like (?)");
            pst.setInt(1, clave_prod);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                prod.setClaveProd(rs.getInt("CLAVE_PROD"));
                prod.setNombre(rs.getString("NOMBRE"));
                prod.setProveedor(rs.getString("PROVEEDOR"));
                ban = true;
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
        
        return ban;
    }
    
}
