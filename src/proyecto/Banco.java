package proyecto;

import java.util.Scanner;

public abstract class Banco {

    private static int saldo;
    protected int transacciones;
    protected int consignacion;
    protected int retiro;
    Scanner sc = new Scanner(System.in);

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        Banco.saldo = saldo;
    }

    public void menu() throws Exception {
        boolean salir = false;
        do {
            System.out.println("Bienvenido");
            System.out.println("    0.salir");
            System.out.println("    1.Crear Cliente");
            System.out.println("    2.Transacciones");
            System.out.println("    3.Mostrar Cliente");
            int opcion = sc.nextInt();
            int numero;
            String nombre;
            String cuenta;
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingresa el numero de cuenta: ");
                    numero = sc.nextInt();
                    System.out.println("Escribe el nombre del cliente:");
                    nombre = sc.next();
                    System.out.println("Ingresa el tipo de cuenta: ");
                    cuenta = sc.next();

                }
                case 2 -> {
                    Banco ca;
                    ca = new CuentaAhorros();
                    ca.menuTransacciones();
                }
                case 3 -> {
                    // Mostrar Clientes
                }
                case 0 -> {
                    System.out.println("Saliendo del programa");
                    salir = true;
                }
            }

        } while (salir == false);
    }

    public void menuTransacciones() throws Exception {
        boolean salir2 = false;
        do {
            System.out.println("Seleccione: ");
            System.out.println("    1. Retirar");
            System.out.println("    2. Consignar");
            System.out.println("    3. Consultar Saldo");
            System.out.println("    0. Atras");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    CuentaAhorros re = new CuentaAhorros();
                    re.Retirar();
                }
                case 2 -> {
                    CuentaAhorros co = new CuentaAhorros();
                    co.Consignar();
                }
                case 3 -> {
                    CuentaAhorros su = new CuentaAhorros();
                    su.Consultar();
                }
                case 0 -> {
                    System.out.println("Cambiando al menu anterior");
                    salir2 = true;
                }
            }
        } while (salir2 == false);
        menu();
    }

    public void Retiro() {
        retiro = sc.nextInt();
    }

    public void Consignado() {
        consignacion = sc.nextInt();
    }

    public abstract void Retirar() throws Exception;

    public abstract void Consignar();

    public abstract void Consultar();

}
