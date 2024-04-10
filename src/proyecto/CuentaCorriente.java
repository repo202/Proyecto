package proyecto;

import java.util.Scanner;

public class CuentaCorriente extends Banco implements Transferir{

    @Override
    public void Retirar() throws Exception {
        try {
            System.out.println("Ingresa la cantidad de dinero a retirar:  ");
            Retiro();
            if (retiro <= getSaldo()) {
                transacciones = getSaldo();
                setSaldo(transacciones - retiro);
                System.out.println("----------------------------------");
                System.out.println("Retiraste: " + retiro);
                System.out.println("Tu saldo actual es: " + getSaldo());
                System.out.println("----------------------------------");
            } else if (retiro > getSaldo()) {
                throw new Exception("Saldo insuficiente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Consignar() {
        System.out.println("Ingresa la cantidad de dinero a consignar corriente:  ");
        Consignado();
        transacciones = getSaldo();
        setSaldo(consignacion + transacciones);
        System.out.println("---------------------------");
        System.out.println("Agregaste: " + consignacion);
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("---------------------------");
    }

    @Override
    public void Consultar() {
        System.out.println("----------------------------------");
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("----------------------------------");
    }

    @Override
    public void transferir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el numero de cuenta al que deseas tranferir: ");
        int n = sc.nextInt();
        System.out.println("Ingrese la cantidad que deseas transferir");
        int descuento = sc.nextInt();
        transacciones = getSaldo();
        setSaldo(transacciones - descuento);
        System.out.println("----------------------------------");
        System.out.println("Retiraste: " + descuento);
        System.out.println("Tu saldo actual es: " + getSaldo());
        System.out.println("----------------------------------");
    }
}
