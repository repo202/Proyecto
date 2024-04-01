package proyecto;

import java.util.Scanner;

/**
 *
 * @author Andres Felipe
 */
public class CuentaAhorros extends CuentaBancaria implements Transaccion{
    
    public CuentaAhorros(String id, int saldo, Cliente cliente) {
        super(id, saldo, cliente);
    }

    @Override
    public int depositar() {
        return 0;
        
    }

    @Override
    public int retirar() {
        return 0;
    }

    @Override
    public int transferir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
