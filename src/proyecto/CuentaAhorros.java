package proyecto;

import java.util.Scanner;

public class CuentaAhorros extends Cuentas implements Transacciones{
    Scanner sc = new Scanner(System.in);

    public CuentaAhorros(String id, int saldo, Clientes cliente) {
            super(id, saldo, cliente);
    }

    @Override
    public void Retirar() throws Exception{
        
        System.out.println("Ingresa la cantidad de dinero a retirar: ");
        int cantidad = sc.nextInt();
        if(cantidad <= getSaldo()) {
             int transacciones = getSaldo();
            setSaldo(transacciones - cantidad);
            System.out.println("----------------------------------");
            System.out.println("Retiraste: " + cantidad);
            System.out.println("Tu saldo actual es: " + getSaldo());
            System.out.println("----------------------------------");
        } else if (cantidad > getSaldo()){
            System.out.println("Saldo insuficiente");
        }
    }
    
    @Override
    public void Consignar() {
        System.out.println("Ingresa la cantidad de dinero a consignar: ");
        int cant = getSaldo();
        int transacciones = getSaldo();
        setSaldo(cant + transacciones);
        System.out.println("---------------------------");
        System.out.println("Agregaste: " + cant);
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("---------------------------");
    }

    @Override
    public void Consultar() {
        System.out.println("----------------------------------");
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("----------------------------------");
    }
}
