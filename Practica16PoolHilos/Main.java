package Practica16PoolHilos;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            int tareaId = i;
            pool.submit(() -> {
                System.out.println("Ejecutando tarea " + tareaId + " en " + Thread.currentThread().getName());
            });
        }

        pool.shutdown();
    }
}