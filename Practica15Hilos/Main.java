package Practica15Hilos;
public class Main {
    public static void main(String[] args) {
        Runnable tarea = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " contando: " + i);
            }
        };

        Thread t1 = new Thread(tarea, "Hilo-1");
        Thread t2 = new Thread(tarea, "Hilo-2");

        t1.start();
        t2.start();
    }
}
