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
    private HashMap<Integer, Cuentas> cuentas;
    private HashMap<Integer, Clientes> clientes;
    Scanner sc = new Scanner(System.in);

    public static int getSaldo() {
        return saldo;
    }

    public static void setSaldo(int saldo) {
        Banco.saldo = saldo;
    }

    public Banco() {
        this.cuentas = new HashMap<>();
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
                    this.crearCliente(id, nombre, apellido);
                }
                case 2 -> {
                    this.mostrarCliente();

                }
                case 3 -> {
                    this.datosCuenta();
                }
                case 4 -> {
                    this.verificar();
                }
                case 5 -> {
                    this.mostrarCuenta();
                }
                case 0 -> {
                    System.out.println("Saliendo del programa");
                    salir = true;
                }
            }

        } while (salir == false);
    }

    public void menuTransaccionesAhorros() throws Exception {
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
    public void menuTransaccionesCorrietne() throws Exception {
        boolean salir3 = false;
        do {
            System.out.println("Seleccione: ");
            System.out.println("    1. Retirar");
            System.out.println("    2. Consignar");
            System.out.println("    3. Consultar Saldo");
            System.out.println("    4. Transferir");
            System.out.println("    0. Atras");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    CuentaCorriente re = new CuentaCorriente();
                    re.Retirar();
                }
                case 2 -> {
                    CuentaCorriente co = new CuentaCorriente();
                    co.Consignar();
                }
                case 3 -> {
                    CuentaCorriente su = new CuentaCorriente();
                    su.Consultar();
                }
                case 4 -> {
                    CuentaCorriente tr = new CuentaCorriente();
                    tr.transferir();
                }
                case 0 -> {
                    System.out.println("Cambiando al menu anterior");
                    salir3 = true;
                }
            }
        } while (salir3 == false);
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
        try {
            if (this.clientes.containsKey(id)) {
                throw new Exception("Cliente repetido");
            } else {
                Clientes c = new Clientes(id, nombre, apellido);
                clientes.put(id, c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarCliente() throws Exception {
        try {
            System.out.println("Ingresa el numero del cliente: ");
            int cuenta = sc.nextInt();
            if (clientes.get(cuenta) == null) {
                throw new Exception("El numero ingresado no se encuentra en el sistema");
            } else {
                System.out.println("-------------------------");
                System.out.println("Datos del cliente: ");
                System.out.println(clientes.toString());
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Verificador de numero de cuenta
    public void verificar() throws Exception {
        try {
            System.out.println("Ingresa el numero de cuenta: ");
            int num = sc.nextInt();
            if (cuentas.containsKey(num) == true) {
                if (cuentas.get(num).getTipoCuenta().equals("Ahorros")) {
                    this.menuTransaccionesAhorros();
                }else {
                    this.menuTransaccionesCorrietne();
                }
            } else if (clientes.containsKey(num) == false) {
                throw new Exception("El numero ingresado no se encuentra en el sistema");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Metodos Crear y mostrar Cuenta
    public void datosCuenta() throws Exception {
        System.out.println("Numero del cliente:");
        int numeroCliente = sc.nextInt();
        System.out.println("Tipo de cuenta:");
        System.out.println("1. Ahorros");
        System.out.println("2. Corriente");
        int n = sc.nextInt();
        ahorrosCorriente(n);
        String tipo = ahorrosCorriente(n);
        System.out.println("Numero de cuenta:");
        int numeroCuenta = sc.nextInt();
        this.crearCuenta(numeroCliente, tipo, numeroCuenta);
    }
    public String ahorrosCorriente (int n) throws Exception{
        if(n == 1) {
            return "Ahorros";
        } else if (n==2) {
            return "Corriente";
        }    
        return null;
    }
    public void crearCuenta(int numeroCliente, String tipo, int numeroCuenta) throws Exception {
        try {
            if (this.clientes.containsKey(numeroCliente)) {
                Cuentas cu = new Cuentas(numeroCliente, tipo, numeroCuenta);
                cuentas.put(numeroCuenta, cu);
            } else {
                throw new Exception("El id del cliente no se encuentra en el sistema");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public void mostrarCuenta() throws Exception {
        try {
            System.out.println("Ingresa el numero de la cuenta");
            int cuenta = sc.nextInt();
            if (cuentas.get(cuenta) == null) {
                throw new Exception("El numero ingresado no se encuentra en el sistema");
            } else {
                System.out.println("-------------------------");
                System.out.println("Datos de la cuenta: ");
                System.out.println(cuentas.toString());
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
