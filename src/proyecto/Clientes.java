package proyecto;

import java.util.HashMap;


public class Clientes {
    protected int id;
    protected String nombre;
    protected String apellido;
    private HashMap<Integer, Cuentas> cuentas;
	
    public int getIdCliente() {
        return id;
    }

    public void setIdCliente(int id) {
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
    
    public Clientes(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido; 
        this.cuentas = new HashMap<Integer, Cuentas>();
    }
    
    public HashMap<Integer, Cuentas> getCuentas() {
		return cuentas;
	}

	public void setCuentas(HashMap<Integer, Cuentas> cuentas) {
		this.cuentas = cuentas;
	}


    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}

