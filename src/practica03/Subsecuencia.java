package practica03;

public class Subsecuencia {

    private int[] array;
    private int primer;
    private int ultimo;
    private int suma;

    // Constructor aleatorio
    public Subsecuencia(int n) {
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 199) - 99; // [-99,99]
        }
    }

    // Constructor copia
    public Subsecuencia(int[] array) {
        this.array = array.clone();
    }

    // Getter del array
    public int[] getArray() {
        return array;
    }

    public int getPrimer() {
        return primer;
    }

    public int getUltimo() {
        return ultimo;
    }

    public int getSuma() {
        return suma;
    }

    //  1. FUERZA BRUTA O(n³)
    public void subsecuenciaFuerzaBruta() {
        suma = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int sumaActual = 0;

                for (int k = i; k <= j; k++) {
                    sumaActual += array[k];
                }

                if (sumaActual > suma) {
                    suma = sumaActual;
                    primer = i;
                    ultimo = j;
                }
            }
        }
    }

    //  2. MEJORADO O(n²)
    public void subsecuenciaMejorado() {
        suma = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int sumaActual = 0;

            for (int j = i; j < array.length; j++) {
                sumaActual += array[j];

                if (sumaActual > suma) {
                    suma = sumaActual;
                    primer = i;
                    ultimo = j;
                }
            }
        }
    }

    //  3. LINEAL O(n) (Kadane)
    public void subsecuenciaLineal() {
        int sumaActual = 0;
        suma = Integer.MIN_VALUE;
        int inicioTemp = 0;

        for (int i = 0; i < array.length; i++) {
            sumaActual += array[i];

            if (sumaActual > suma) {
                suma = sumaActual;
                primer = inicioTemp;
                ultimo = i;
            }

            if (sumaActual < 0) {
                sumaActual = 0;
                inicioTemp = i + 1;
            }
        }
    }
}
