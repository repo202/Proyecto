package proyecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class Banco {

    private static int saldo;
    protected int transacciones;
    protected int consignacion;
    protected int retiro;
    private List<Cuentas> cuentas;
    private HashMap<Integer,Clientes> clientes;
    Scanner sc = new Scanner(System.in);

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        Banco.saldo = saldo;
    }

    public Banco() {
        this.cuentas = new ArrayList<>();
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
                    System.out.println("Ingresa el numero del cliente: ");
                    int id = sc.nextInt();
                    crearCliente(id,nombre,apellido);
                }
                case 2 -> {
                    mostrarCliente();
                    
                }
                case 3 -> {
                    datosCuenta();
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
            Clientes c = new Clientes(id,nombre,apellido);
            clientes.put(id,c);
        }
    }
    
    public void mostrarCliente() {
        System.out.println("Ingresa el numero del cliente: ");
        int cuenta = sc.nextInt();
        if (clientes.get(cuenta) == null) {
            System.out.println("El numero ingresado no se encuentra en el sistema");
        } else {
            System.out.println("-------------------------");
            System.out.println("Datos del cliente: ");
            System.out.println(clientes.toString());
            System.out.println("-------------------------");
        }
    }
    
    //Verificador de numero de cuenta
    public void verificar() throws Exception {
        System.out.println("Ingresa el numero del cliente: ");
        int num = sc.nextInt();
        if (clientes.containsKey(num)) {
            this.menuTransacciones();
        } else {
            System.out.println("El numero ingresado no se encuentra en el sistema");
        }
    }
    //Metodo Crear y mostrar Cuenta
    public void datosCuenta () {
        System.out.println("Numero del cliente:");
	int numeroCliente = sc.nextInt();
	System.out.println("Tipo de cuenta:");
	String tipo = sc.next();
	System.out.println("Numero de cuenta:");
	int numeroCuenta = sc.nextInt();
	this.crearCuenta(numeroCliente, tipo, numeroCuenta);
    }
    public void crearCuenta (int numeroCliente, String tipo, int numeroCuenta) {
        boolean determinante;
        determinante = clientes.containsKey(numeroCliente);
        if (determinante == false) {
            System.out.println("El cliente ingresado no existe");
        } else if (determinante == true){
            Cuentas cuenta = new Cuentas(numeroCliente, tipo, numeroCuenta);
            this.cuentas.add(cuenta);
        } 
    }
}
