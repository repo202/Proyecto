package proyecto;

import java.util.HashMap;


public class Clientes {
    private int id;
    private String nombre;
    private String apellido;
    private HashMap<Integer, Cuentas> cuentas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public HashMap<Integer, Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(HashMap<Integer, Cuentas> cuentas) {
        this.cuentas = cuentas;
    }
    
    
    public Clientes(int id, String nombre, String apellido) {
        this.cuentas = new HashMap<>();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        
    }
    
    public String toString() {
        return "id: " + id + ", nombre: " + nombre + ", apellido: " + apellido;
    }
    
}

