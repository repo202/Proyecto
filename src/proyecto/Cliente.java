package proyecto;

import java.util.ArrayList;
import java.util.List;



public class Cliente {
    public int numeroCuenta;
    public String nombre;
    public String tipoCuenta;
    public List<Cliente> listaCliente; 
    

    public Cliente() {
        
    }
    public Cliente(int numeroCuenta, String nombre, String tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
    public void guardarCliente () {
        listaCliente = new ArrayList<Cliente>();
        listaCliente.add(new Cliente(numeroCuenta, nombre, tipoCuenta));
    }
    public void mostrarCliente () {
        for (Cliente client : listaCliente) {
            System.out.println("Cliente: ");
            System.out.println("Cuenta Nombre  Tipo Cuenta");
            System.out.println(client.getNumeroCuenta() + " | " + client.getNombre() + " | " + client.getTipoCuenta());
        }
    }
    
}
