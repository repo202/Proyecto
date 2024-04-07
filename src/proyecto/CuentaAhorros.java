package proyecto;

public class CuentaAhorros extends Banco  {
    
    @Override
    public void Retirar() throws Exception{
        System.out.println("Ingresa la cantidad de dinero a retirar: ");
        Retiro();
        if(retiro <= getSaldo()) {
            transacciones = getSaldo();
            setSaldo(transacciones - retiro);
            System.out.println("----------------------------------");
            System.out.println("Retiraste: " + retiro);
            System.out.println("Tu saldo actual es: " + getSaldo());
            System.out.println("----------------------------------");
        } else if (retiro > getSaldo()){
            System.out.println("Saldo insuficiente");
        }
    }
    
    @Override
    public void Consignar() {
        System.out.println("Ingresa la cantidad de dinero a consignar: ");
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
}
