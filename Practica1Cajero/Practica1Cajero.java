package Practica1Cajero;
import java.util.Scanner;
import java.util.ArrayList;

public class Practica1Cajero {
    public static void main(String[] args) {
        Operador op = new Operador();
        System.out.println("=== Bienvenido al Cajero ===");
        op.crearU();
    }
}

class Operador{
    Scanner scanner = new Scanner(System.in);
        ArrayList<String> usuarios = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Double> saldos = new ArrayList<>();
        int intentos = 0, usuarioActual =-1;
        boolean salir = false;

    String crearU () {
        String nombresreg;
        String usuarioreg;
        double saldoreg;
        boolean veri = true;
        int creacion = 0;

        while (veri) {
            System.out.println("Teclea 1 para registrar usuario, tecla otro numero para salir");
            creacion = scanner.nextInt();
            scanner.nextLine();
            switch (creacion) {
                case 1:
                    System.out.println("Registra el nombre de usuario: ");
                    nombresreg = scanner.nextLine();
                    nombres.add(nombresreg);
                    System.out.println("Registra el pin del usuario: ");
                    usuarioreg = scanner.nextLine();
                    usuarios.add(usuarioreg);
                    System.out.println("Registra el saldo del usuario: ");
                    saldoreg = scanner.nextDouble();
                    saldos.add(saldoreg);
                    System.out.println("Registro con exito");
                    break;
                default:
                    veri = false;
                    break;
            }
            
        }
        this.inicioS();
        return(" ");
    }

    String inicioS () {
        while (intentos < 3 && usuarioActual == -1) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).equals(pin)) {
                    usuarioActual = i;
                    break;
                }
            }
            if (usuarioActual == -1) {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
        }

        if (usuarioActual == -1) {
            System.out.println("Demasiados intentos fallidos. Adiós.");
        }

        System.out.println("Bienvenido, " + nombres.get(usuarioActual));

        while (!salir) {
            this.opciones();
        }
        return(" ");
    }

    String opciones() {
        System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println(this.vSaldo());
                    break;
                case 2:
                    System.out.println(this.rDinero());
                    break;
                case 3:
                    System.out.println(this.iDinero());
                    break;
                default:
                    salir = true;
                    break;
            }
        return(" ");
    }

    String vSaldo () {
        System.out.println("Bienvenido a la consulta de saldo, " + nombres.get(usuarioActual));
        System.out.println("Tu saldo actual es de " + saldos.get(usuarioActual));
        
        System.out.println("Presiona cualquier tecla para continuar...");
        String opcionsalida;
        opcionsalida = scanner.nextLine();
        switch (opcionsalida) {
            default:
            this.opciones();
                break;
        }
        return(" ");
    }

    String rDinero (){
        double dinero =0;
        boolean ver = true;
        double actual = saldos.get(usuarioActual);

        while (ver){
            System.out.println("Elige una cantidad a retirar...");
            dinero = scanner.nextDouble();

            if(dinero > saldos.get(usuarioActual)){
            System.out.println("Dinero insuficiente, chambeale mas hijo");
            }else{
                saldos.set(usuarioActual, actual - dinero);
                System.out.println("Tu saldo ahora es de: " + saldos.get(usuarioActual));
                ver=false;
            }
        }
        
        System.out.println("Presiona cualquier numero para continuar...");
        int opcionsalida;
        opcionsalida = scanner.nextInt();
        switch (opcionsalida) {
            default:
            this.opciones();
                break;
        }
        return(" ");
    }

    String iDinero (){
        double dinero =0;
        double actual = saldos.get(usuarioActual);
        System.out.println("Elige una cantidad a ingresar...");
        dinero = scanner.nextDouble();
        saldos.set(usuarioActual, actual + dinero);
        System.out.println("Tu saldo ahora es de: " + saldos.get(usuarioActual));

        System.out.println("Presiona cualquier numero para continuar...");
        int opcionsalida;
        opcionsalida = scanner.nextInt();
        switch (opcionsalida) {
            default:
            this.opciones();
                break;
        }
        return(" ");
    }    
}