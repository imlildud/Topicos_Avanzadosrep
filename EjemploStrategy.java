import java.util.HashMap;
import java.util.Scanner;

public class EjemploStrategy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Carrito car = new Carrito();
        int opcion;

        HashMap<Integer, MetodoPago> estrategias = new HashMap<>();
        estrategias.put(1, new PagoEfectivo("SARJ050712HMGTNDSA1"));
        estrategias.put(2, new PagoTarjeta("23456-78901"));
        estrategias.put(3, new PagoPaypal("Aef35-23FG"));

        System.out.println("Bienvenido al sistema de pago");
        System.out.println("1.- Efectivo");
        System.out.println("2.- Tarjeta");
        System.out.println("3.- Paypal");

        opcion = sc.nextInt();

        MetodoPago elegido = estrategias.get(opcion);

        car.setMetodoPago(elegido);
        car.procesarCompra(320.3);
    }
}

class Carrito{
    private MetodoPago metodoPago;

    public void setMetodoPago(MetodoPago metodoPago){
        this.metodoPago = metodoPago;
    }

    public void procesarCompra(double monto){
        metodoPago.pagar(monto);
    }
}

abstract class MetodoPago {
    abstract void pagar(double monto);
}

class PagoEfectivo extends MetodoPago {
    private final String curp;

    public PagoEfectivo (String curp){
        this.curp = curp;
    }
    @Override

    void pagar(double monto){
            System.out.println("Pagando $" + monto  + " con la curp de: " + curp);
        }
}

class PagoTarjeta extends MetodoPago{
    private final String numeroTarjeta;

    public PagoTarjeta (String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }
    @Override

    void pagar(double monto){
        System.out.println("Pagando $" + monto + " con el numero de tarjeta de: " + numeroTarjeta);
    }
}

class PagoPaypal extends MetodoPago{
    private final String wallet;

    public PagoPaypal (String wallet){
        this.wallet = wallet;
    }
    @Override

    void pagar(double monto){
        System.out.println("Pagando $" + monto + " con la id Wallet de: " + wallet);
    }
}