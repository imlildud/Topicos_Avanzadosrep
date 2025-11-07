package Practica1GestorArchivos;

import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner DC = new Scanner(System.in);
    static String RUTA_BASE = "src/Practica1GestorArchivos";

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n MENU ");
            System.out.println("1. Registrar alumno");
            System.out.println("2. Eliminar alumno");
            System.out.println("3. Ver alumnos");
            System.out.println("4. Actualizar promedio");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            try {
                opcion = Integer.parseInt(DC.nextLine().trim());
            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1: registrarAlumno(); break;
                case 2: eliminarAlumno(); break;
                case 3: mostrarAlumnos(); break;
                case 4: actualizarPromedio(); break;
                case 5: System.out.println("Ha concluido el programa."); break;
                default: System.out.println("Opcion no valida."); break;
            }

        } while (opcion != 5);
    }

    private static void registrarAlumno() {
        try {
            System.out.print("Digite el numero de control: ");
            String numeroControl = DC.nextLine().trim();

            System.out.print("Nombre: ");
            String nombre = DC.nextLine().trim();

            System.out.print("Semestre: ");
            String semestre = DC.nextLine().trim();

            System.out.print("Promedio: ");
            double promedio = Double.parseDouble(DC.nextLine().trim());

            String datos = numeroControl + ",  " + nombre + ",  " + semestre + ",  " + promedio + "\n";
            String archivo = (promedio >= 70) ? "acreditado.txt" : "no_acreditado.txt";

            FileWriter fw = new FileWriter(RUTA_BASE + archivo, true);
            fw.write(datos);
            fw.close();

            System.out.println("Alumno registrado en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al registrar alumno: " + e.getMessage());
        }
    }

    private static void eliminarAlumno() {
        try {
            System.out.print("Numero de control del alumno a eliminar: ");
            String numeroControl = DC.nextLine().trim();

            boolean elim1 = eliminarDeArchivo(numeroControl, "acreditado.txt");
            boolean elim2 = eliminarDeArchivo(numeroControl, "no_acreditado.txt");

            if (elim1 || elim2) System.out.println("Alumno eliminado correctamente.");
            else System.out.println("No se encontró el alumno.");
        } catch (IOException e) {
            System.out.println("Error al eliminar alumno: " + e.getMessage());
        }
    }

    private static boolean eliminarDeArchivo(String numeroControl, String archivoNombre) throws IOException {
        File original = new File(RUTA_BASE + archivoNombre);
        File temporal = new File(RUTA_BASE + "temporal.txt");

        if (!original.exists()) return false;

        BufferedReader br = new BufferedReader(new FileReader(original));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temporal));

        boolean eliminado = false;
        String linea;
        String prefijo = numeroControl + ",";
        while ((linea = br.readLine()) != null) {
            if (!linea.startsWith(prefijo)) {
                bw.write(linea);
                bw.write("\n");
            } else {
                eliminado = true;
            }
        }
        br.close();
        bw.close();

        if (original.delete()) temporal.renameTo(original);
        return eliminado;
    }

    private static void mostrarAlumnos() {
        System.out.println("\n--- Alumnos Acreditados ---");
        leerArchivo("acreditado.txt");
        System.out.println("\n--- Alumnos No Acreditados ---");
        leerArchivo("no_acreditado.txt");
    }

    private static void leerArchivo(String archivoNombre) {
        try {
            File f = new File(RUTA_BASE + archivoNombre);
            if (!f.exists()) {
                System.out.println("No hay datos en " + archivoNombre);
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    private static void actualizarPromedio() {
        try {
            System.out.print("Numero de control: ");
            String numeroControl = DC.nextLine().trim();

            System.out.print("Nuevo promedio: ");
            double nuevoPromedio = Double.parseDouble(DC.nextLine().trim());

            boolean ok = actualizarPromedioEnArchivo(numeroControl, nuevoPromedio, "acreditado.txt", "no_acreditado.txt");
            if (!ok) ok = actualizarPromedioEnArchivo(numeroControl, nuevoPromedio, "no_acreditado.txt", "acreditado.txt");

            if (ok) System.out.println("Promedio actualizado correctamente.");
            else System.out.println("No se encontró el alumno.");
        } catch (Exception e) {
            System.out.println("Error al actualizar promedio: " + e.getMessage());
        }
    }

    private static boolean actualizarPromedioEnArchivo(String numeroControl, double nuevoPromedio,
                                                       String origen, String destino) throws IOException {
        File original = new File(RUTA_BASE + origen);
        if (!original.exists()) return false;

        File temporal = new File(RUTA_BASE + "temporal.txt");
        BufferedReader br = new BufferedReader(new FileReader(original));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temporal));

        boolean encontrado = false;
        String linea;
        String prefijo = numeroControl + ",";

        while ((linea = br.readLine()) != null) {
            if (!linea.startsWith(prefijo)) {
                bw.write(linea);
                bw.write("\n");
            } else {
                encontrado = true;

                int ultimaComa = linea.lastIndexOf(',');
                String base = (ultimaComa == -1) ? linea : linea.substring(0, ultimaComa).trim();
                String nuevaLinea = base + ",  " + nuevoPromedio + "\n";

                boolean nuevoAcreditado = (nuevoPromedio >= 70);
                boolean origenEsAcreditado = origen.equals("acreditado.txt");

                if (nuevoAcreditado == origenEsAcreditado) {
                    bw.write(nuevaLinea);
                } else {
                    agregarLinea(destino, nuevaLinea);
                }
            }
        }

        br.close();
        bw.close();

        if (encontrado) {
            original.delete();
            temporal.renameTo(original);
        } else {
            temporal.delete();
        }
        return encontrado;
    }

    private static void agregarLinea(String archivoDestino, String linea) {
        try {
            FileWriter fw = new FileWriter(RUTA_BASE + archivoDestino, true);
            fw.write(linea);
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al mover alumno: " + e.getMessage());
        }
    }
}