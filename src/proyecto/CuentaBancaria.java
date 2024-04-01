package proyecto;

/**
 *
 * @author Andres Felipe
 */
public abstract class CuentaBancaria {
    private String id;
    int saldo;
    Cliente cliente;

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public CuentaBancaria(String id, int saldo,Cliente cliente) {
        this.id = id;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    
    
}
