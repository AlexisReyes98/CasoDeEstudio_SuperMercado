
package Model;

/**
 *
 * @author alexis
 */
public class Asignacion {
    private int claveProd;
    private double precio;
    private String claveDepto;

    // Constructor basio
    public Asignacion() {
    }
    
    // Constructor
    public Asignacion(int claveProd, double precio, String claveDepto) {
        this.claveProd = claveProd;
        this.precio = precio;
        this.claveDepto = claveDepto;
    }
    
    // Getters y Setters
    public int getClaveProd() {
        return claveProd;
    }

    public void setClaveProd(int claveProd) {
        this.claveProd = claveProd;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClaveDepto() {
        return claveDepto;
    }

    public void setClaveDepto(String claveDepto) {
        this.claveDepto = claveDepto;
    }
    
}
