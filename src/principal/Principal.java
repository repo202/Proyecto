package principal;

import proyecto.Banco;
import proyecto.CuentaAhorros;
public class Principal {
    
    public static void main(String[] args) throws Exception {
        Banco b = new CuentaAhorros();
        Banco.setSaldo(0);
        b.menu();
    }
}
