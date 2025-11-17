package Practica17SincronizacionHilos;

public class Main {
    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public static void main(String[] args) throws InterruptedException {
        Main mn = new Main();

        Runnable tarea = () -> {
            for (int i = 0; i < 1000; i++) mn.incrementar();
        };

        Thread t1 = new Thread(tarea);
        Thread t2 = new Thread(tarea);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Resultado final: " + mn.getContador());
    }
}