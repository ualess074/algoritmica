package practica03.ejercicio1_1;

public class TiemposMatrizEnterosCuadradaApp {

    public static void main(String[] args) {
        
        System.out.println("Iniciando análisis de tiempos (Método de Selección por Filas)...\n");
        System.out.println("Tamaño (n)\tTiempo Medio (ms)");
        System.out.println("---------------------------------");

        // Bucle para los diferentes tamaños de n
        for (int n = 32; n <= 8192; n *= 2) {
            
            // 1. Crear matriz de n x n aleatoria
            MatrizEnterosCuadrada matrizOriginal = new MatrizEnterosCuadrada(n);
            
            // Array para guardar los 10 tiempos 
            long[] tiempos = new long[10];
            
            for (int i = 0; i < 10; i++) {
                
                // Tiempo inicial
                long tiempoInicio = System.currentTimeMillis();
                

                matrizOriginal.matrizOrdenadaPorFilas();
                
                // Tiempo final
                long tiempoFin = System.currentTimeMillis();
                
                // Guardamos el tiempo 
                tiempos[i] = (tiempoFin - tiempoInicio);
            }

            // 3. Descartar el valor máximo y calcular la media
            long tiempoMaximo = tiempos[0];
            long sumaTiempos = 0;

            // Buscamos el máximo y sumamos todos
            for (int i = 0; i < 10; i++) {
                if (tiempos[i] > tiempoMaximo) {
                    tiempoMaximo = tiempos[i];
                }
                sumaTiempos += tiempos[i];
            }

            // Restamos el tiempo máximo de la suma total
            sumaTiempos = sumaTiempos - tiempoMaximo;

            // Calculamos la media de los 9 restantes 
            double tiempoMedio = sumaTiempos / 9.0;

            // Imprimimos el resultado para rellenar la tabla
            System.out.printf("n = %d\t\t%.2f ms\n", n, tiempoMedio);
        }
        
        System.out.println("\nFin de las pruebas.");
    }
}