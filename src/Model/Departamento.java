
package Model;

/**
 *
 * @author alexis
 */
public class Departamento {
    private String claveDepto;
    private String nombre;
    private String jefe;

    // Constructor vacío
    public Departamento() {
    }
    
    // Constructor

    public Departamento(String claveDepto, String nombre, String jefe) {
        this.claveDepto = claveDepto;
        this.nombre = nombre;
        this.jefe = jefe;
    }
    
    // Getters y Setters

    public String getClaveDepto() {
        return claveDepto;
    }

    public void setClaveDepto(String claveDepto) {
        this.claveDepto = claveDepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }
    
}
