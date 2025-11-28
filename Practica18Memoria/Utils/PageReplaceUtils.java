package Practica18Memoria.Utils;
import java.util.Arrays;

public class PageReplaceUtils {
    public static boolean contiene(String[] frames, String pagina) {
        for (String f : frames) {
            if (f != null && f.equals(pagina)) return true;
        }
        return false;
    }

    public static int indiceVacio(String[] frames) {
        for (int i = 0; i < frames.length; i++) {
            if (frames[i] == null) return i;
        }
        return -1;
    }

    public static String[] copia(String[] frames) {
        return Arrays.copyOf(frames, frames.length);
    }
}