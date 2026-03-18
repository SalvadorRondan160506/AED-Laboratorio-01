package pypooeje2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TerrenoMinero terreno = new TerrenoMinero();

        try {
            System.out.print("Ingrese el nombre del archivo: ");
            String nombreArchivo = sc.nextLine();

            terreno.cargarArchivo(nombreArchivo);

            System.out.print("Ingrese el tamaño de la subregión k: ");
            int k = sc.nextInt();

            terreno.buscarMejorRegion(k);

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo.");
        }

        sc.close();
    }
}