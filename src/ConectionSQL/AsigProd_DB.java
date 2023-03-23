
package ConectionSQL;

import Model.Asignacion;
import Model.Producto;
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
public class AsigProd_DB {
    /*
    *   Sistema que administra los productos en un departamento del super
    */
    
    // Código para INSERTAR un nuevo producto a un depto en la tabla de la BD
    public void altaAsignacionProducto(Asignacion asig) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO ASIG_PROD(CLAVE_PROD,PRECIO,CLAVE_DEPTO)"
                    + " VALUES (?,?,?)");
            pst.setInt(1, asig.getClaveProd());
            pst.setDouble(2, asig.getPrecio());
            pst.setString(3, asig.getClaveDepto());
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
    
    // Código para utilizar el Procedimiento almacenado de Oracle PL/SQL (BAJA_ASIGPROD)
    public void bajaAsignacionProducto(int clave_producto) {
        Connection cnx = DataBaseConexion.getConnection();
        try {
            // Se realiza la llamada al pocedimiento de la BD
            CallableStatement cst = cnx.prepareCall("{call BAJA_ASIGPROD (?)}");
            
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
    public boolean buscaProductoDepto(int clave_prod) {
        Connection cnx = DataBaseConexion.getConnection();
        Asignacion asig = new Asignacion();
        boolean ban = false;
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_PROD,PRECIO,CLAVE_DEPTO"
                    + " FROM ASIG_PROD WHERE CLAVE_PROD like (?)");
            pst.setInt(1, clave_prod);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                asig.setClaveProd(rs.getInt("CLAVE_PROD"));
                asig.setPrecio(Double.parseDouble(rs.getString("PRECIO")));
                asig.setClaveDepto(rs.getString("CLAVE_DEPTO"));
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
    
    // Código para VER los productos en un departamento
    public ArrayList<Producto> consultarProductos(String clave_depto) {
        ArrayList<Producto> productos = new ArrayList();
        Connection cnx = DataBaseConexion.getConnection();
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_PROD"
                    + " FROM ASIG_PROD WHERE CLAVE_DEPTO like (?)");
            pst.setString(1, clave_depto);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                productos.add(regresaProductoDepto(rs.getInt("CLAVE_PROD")));
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
    
    // Código para REGRESAR un producto en la tabla de la BD
    public Producto regresaProductoDepto(int clave_prod) {
        Connection cnx = DataBaseConexion.getConnection();
        Producto prod = new Producto();
        try {
            PreparedStatement pst = cnx.prepareStatement("SELECT CLAVE_PROD,NOMBRE,PROVEEDOR"
                    + " FROM PRODUCTOS WHERE CLAVE_PROD like (?)");
            pst.setInt(1, clave_prod);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                prod.setClaveProd(rs.getInt("CLAVE_PROD"));
                prod.setNombre(rs.getString("NOMBRE"));
                prod.setProveedor(rs.getString("PROVEEDOR"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al obtener el producto");
        } finally {
            try {
                cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return prod;
    }
    
}
