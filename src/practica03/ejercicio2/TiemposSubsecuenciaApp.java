package practica03.ejercicio2;

public class TiemposSubsecuenciaApp {

    public static void main(String[] args) {

        int[] tamanos = {64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768};

        System.out.println("n\tFuerzaBruta\tMejorado\tLineal");

        for (int n : tamanos) {

            Subsecuencia s = new Subsecuencia(n);
            int[] array = s.getArray();

            long tFB = medirFuerzaBruta(array);
            long tMejorado = medirMejorado(array);
            long tLineal = medirLineal(array);

            System.out.println(n + "\t" + tFB + "\t" + tMejorado + "\t" + tLineal);
        }
    }

    //  FUERZA BRUTA
    private static long medirFuerzaBruta(int[] array) {
        long[] tiempos = new long[10];

        for (int i = 0; i < 10; i++) {
            Subsecuencia s = new Subsecuencia(array);

            long inicio = System.nanoTime();
            s.subsecuenciaFuerzaBruta();
            long fin = System.nanoTime();

            tiempos[i] = fin - inicio;
        }

        return mediaSinMax(tiempos);
    }

    //  MEJORADO
    private static long medirMejorado(int[] array) {
        long[] tiempos = new long[10];

        for (int i = 0; i < 10; i++) {
            Subsecuencia s = new Subsecuencia(array);

            long inicio = System.nanoTime();
            s.subsecuenciaMejorado();
            long fin = System.nanoTime();

            tiempos[i] = fin - inicio;
        }

        return mediaSinMax(tiempos);
    }

    //  LINEAL
    private static long medirLineal(int[] array) {
        long[] tiempos = new long[10];

        for (int i = 0; i < 10; i++) {
            Subsecuencia s = new Subsecuencia(array);

            long inicio = System.nanoTime();
            s.subsecuenciaLineal();
            long fin = System.nanoTime();

            tiempos[i] = fin - inicio;
        }

        return mediaSinMax(tiempos);
    }

    //  MEDIA SIN EL MÁXIMO
    private static long mediaSinMax(long[] tiempos) {
        long suma = 0;
        long max = tiempos[0];

        for (long t : tiempos) {
            suma += t;
            if (t > max) {
                max = t;
            }
        }

        return (suma - max) / (tiempos.length - 1);
    }
}
