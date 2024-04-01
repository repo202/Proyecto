
package principal;

import java.util.Scanner;
import proyecto.Cliente;

public class Proyecto {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            boolean salir = false;
            
            do {
                System.out.println("Bienvenido");
                System.out.println("0.salir");
                System.out.println("1.Crear Cliente");
                System.out.println("2.Mostrar Cliente");
                int opcion = sc.nextInt();
                int numero;
                String nombre;
                String cuenta;
                Cliente c;
            switch (opcion) {    
                case 1 -> {
                    System.out.println("Ingresa el numero de cuenta: ");
                    numero = sc.nextInt();
                    System.out.println("Escribe el nombre del cliente:");
                    nombre = sc.next();
                    System.out.println("Ingresa el tipo de cuenta: ");
                    cuenta = sc.next();
                    c = new Cliente(numero,nombre, cuenta);
                    c.guardarCliente();
                }
                case 2 -> {
                }
                case 0 -> salir = true;
            }
            // Mostrar Cliente
                        
            } while (salir == false);
    }
}
