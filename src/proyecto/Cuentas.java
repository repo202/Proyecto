package proyecto;

import java.util.Scanner;

public class Cuentas implements Transacciones{
        Scanner sc = new Scanner(System.in);

        protected int numero;
	protected int saldo;
	protected Clientes cliente;

    Cuentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Cuentas(int numero, int saldo, Clientes cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
                this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		return this.numero + "\t" + this.saldo + "\t" + this.cliente;
	}

    @Override
    public void Retirar() throws Exception {
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
        System.out.println("---------------------------");    }

    @Override
    public void Consultar() {
        System.out.println("----------------------------------");
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("----------------------------------");    }
}
