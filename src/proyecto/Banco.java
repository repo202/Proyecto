package proyecto;

import java.util.HashMap;
import java.util.Scanner;

public abstract class Banco {

    private static int saldo;
    protected int transacciones;
    protected int consignacion;
    protected int retiro;
    protected HashMap<Integer,String> clientes;
    Scanner sc = new Scanner(System.in);

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        Banco.saldo = saldo;
    }

    public Banco() {
        this.clientes = new HashMap<>();
    }

    public void menu() throws Exception {
        boolean salir = false;
        do {
            System.out.println("Bienvenido");
            System.out.println("    0.salir");
            System.out.println("    1.Crear Cliente");
            System.out.println("    2.Mostrar Cliente");
            System.out.println("    3.Crear Cuenta");
            System.out.println("    4.Transacciones");
            System.out.println("    5.Mostrar Cuenta");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Datos del cliente: ");
                    System.out.println("Ingresa el nombre: ");
                    String nombre = sc.next();
                    System.out.println("Ingresa el apellido: ");
                    String apellido = sc.next();
                    System.out.println("Ingresa el numero de cuenta: ");
                    int id = sc.nextInt();
                    crearCliente(id,nombre,apellido);
                }
                case 2 -> {
                    mostrarCliente();
                    
                }
                case 3 -> {
                    // Crear Cuenta
                }
                case 4 -> {
                    verificar();
                }
                case 5 -> {
                    // Mostrar Cuenta
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
        this.menu();
    }

    public void Retiro() {
        retiro = sc.nextInt();
    }

    public void Consignado() {
        consignacion = sc.nextInt();
    }
    
    //Métodos abstractos transacciones
    public abstract void Retirar() throws Exception;
    public abstract void Consignar();
    public abstract void Consultar();
    
    
    //Metodos crear y mostrar Cliente
    public void crearCliente(int id, String nombre, String apellido) throws Exception {
        if (this.clientes.containsKey(id)) {
            System.out.println("Cliente repetido");
        } else {
            clientes.put(id,nombre);
        }
    }
    
    public void mostrarCliente() {
        System.out.println("Ingresa tu numero de cuenta: ");
        int cuenta = sc.nextInt();
        if (clientes.get(cuenta) == null) {
            System.out.println("El numero ingresado no se encuentra en el sistema");
        } else {
            System.out.println("-------------------------");
            System.out.println("Datos del cliente: ");
            System.out.println("Titular: " + clientes.get(cuenta));
            System.out.println("-------------------------");
        }
    }
    
    //Verificador de numero de cuenta
    public void verificar() throws Exception {
        System.out.println("Ingresa tu numero de cuenta: ");
        int num = sc.nextInt();
        if (clientes.containsKey(num)) {
            this.menuTransacciones();
        } else {
            System.out.println("El numero ingresado no se encuentra en el sistema");
        }
    }
}
