    
package Model;

/**
 *
 * @author alexis
 */
public class Producto {
    private int claveProd;
    private String nombre;
    private String proveedor;
    
    // Constructor vacío
    public Producto() {
    }

    // Constructor
    public Producto(int claveProd, String nombre, String proveedor) {
        this.claveProd = claveProd;
        this.nombre = nombre;
        this.proveedor = proveedor;
    }

    // Getters y Setters
    public int getClaveProd() {
        return claveProd;
    }

    public void setClaveProd(int claveProd) {
        this.claveProd = claveProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
}
