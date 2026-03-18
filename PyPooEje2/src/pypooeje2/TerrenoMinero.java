package pypooeje2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TerrenoMinero {
    private Zona[][] matriz;
    private int filas;
    private int columnas;

    public void cargarArchivo(String nombreArchivo) throws FileNotFoundException {
        Scanner archivo = new Scanner(new File(nombreArchivo));

        filas = archivo.nextInt();
        columnas = archivo.nextInt();

        matriz = new Zona[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String mineral = archivo.next();
                double cantidad = archivo.nextDouble();
                double pureza = archivo.nextDouble();

                matriz[i][j] = new Zona(mineral, cantidad, pureza);
            }
        }

        archivo.close();
    }

    public void buscarMejorRegion(int k) {
        double mayorValor = -1;
        int mejorFila = 0;
        int mejorColumna = 0;

        for (int i = 0; i <= filas - k; i++) {
            for (int j = 0; j <= columnas - k; j++) {
                double suma = calcularValorRegion(i, j, k);

                if (suma > mayorValor) {
                    mayorValor = suma;
                    mejorFila = i;
                    mejorColumna = j;
                }
            }
        }

        System.out.println("\nRegión más valiosa encontrada:\n");
        System.out.println("Posición inicial: (" + (mejorFila + 1) + "," + (mejorColumna + 1) + ")");
        System.out.println("Tamaño de la región: " + k + " x " + k);
        System.out.println("\nZonas analizadas:");

        for (int i = mejorFila; i < mejorFila + k; i++) {
            for (int j = mejorColumna; j < mejorColumna + k; j++) {
                System.out.println(matriz[i][j]);
            }
        }

        System.out.println("\nValor total estimado: " + mayorValor);
        System.out.println("\nMineral predominante en la región: " + mineralPredominante(mejorFila, mejorColumna, k));
    }

    private double calcularValorRegion(int filaInicio, int colInicio, int k) {
        double suma = 0;

        for (int i = filaInicio; i < filaInicio + k; i++) {
            for (int j = colInicio; j < colInicio + k; j++) {
                suma += matriz[i][j].getValorEconomico();
            }
        }

        return suma;
    }

    private String mineralPredominante(int filaInicio, int colInicio, int k) {
        String[] minerales = new String[k * k];
        int[] repeticiones = new int[k * k];
        int total = 0;

        for (int i = filaInicio; i < filaInicio + k; i++) {
            for (int j = colInicio; j < colInicio + k; j++) {
                String mineralActual = matriz[i][j].getMineral();
                boolean encontrado = false;

                for (int m = 0; m < total; m++) {
                    if (minerales[m].equals(mineralActual)) {
                        repeticiones[m]++;
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    minerales[total] = mineralActual;
                    repeticiones[total] = 1;
                    total++;
                }
            }
        }

        int mayor = repeticiones[0];
        String predominante = minerales[0];

        for (int i = 1; i < total; i++) {
            if (repeticiones[i] > mayor) {
                mayor = repeticiones[i];
                predominante = minerales[i];
            }
        }

        return predominante;
    }
}