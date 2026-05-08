package practica03.ejercicio1_1;

import java.util.Arrays;
import java.util.Random;

public class MatrizEnterosCuadrada {
    
    private int[][] matriz;

    // Constructor 1
    public MatrizEnterosCuadrada(int numeroFilasCol) {
        this.matriz = new int[numeroFilasCol][numeroFilasCol];
        Random rnd = new Random();
        
        for (int i = 0; i < numeroFilasCol; i++) {
            for (int j = 0; j < numeroFilasCol; j++) {
                this.matriz[i][j] = rnd.nextInt(100); // Números del 0 al 99
            }
        }
    }

    // Constructor 2
    public MatrizEnterosCuadrada(int[][] m) {
        int n = m.length;
        this.matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            this.matriz[i] = Arrays.copyOf(m[i], n);
        }
    }

    // Getters
    public int[][] getMatriz() {
        return matriz;
    }

    // Método de ordenación por selección 
    public static void ordenaSeleccion(int A[]) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < A.length - 1; i++) {
            menor = A[i];     
            pos = i;          
            for (j = i + 1; j < A.length; j++) { 
                if (A[j] < menor) {              
                    menor = A[j];                
                    pos = j;
                }
            }
            if (pos != i) {   
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
            }
        }
    }

    // Método principal
    public MatrizEnterosCuadrada matrizOrdenadaPorFilas() {
        int n = this.matriz.length;
        int[][] nuevaMatriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            nuevaMatriz[i] = Arrays.copyOf(this.matriz[i], n);
            ordenaSeleccion(nuevaMatriz[i]);
        }

        return new MatrizEnterosCuadrada(nuevaMatriz);
    }

    // Método toString 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            sb.append(Arrays.toString(matriz[i])).append("\n");
        }
        return sb.toString();
    }
}