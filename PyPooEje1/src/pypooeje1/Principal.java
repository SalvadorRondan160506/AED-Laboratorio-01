package pypooeje1;

import java.util.Scanner;

public class Principal {

    public static void mostrarRectangulo(String nombre, Rectangulo r) {
        System.out.println("Rectangulo " + nombre + " = " + r);
    }

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        double xIzq = Math.max(r1.getMinX(), r2.getMinX());
        double xDer = Math.min(r1.getMaxX(), r2.getMaxX());
        double yInf = Math.max(r1.getMinY(), r2.getMinY());
        double ySup = Math.min(r1.getMaxY(), r2.getMaxY());

        Coordenada c1 = new Coordenada(xIzq, yInf);
        Coordenada c2 = new Coordenada(xDer, ySup);

        return new Rectangulo(c1, c2);
    }

    public static Coordenada leerCoordenada(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        return new Coordenada(x, y);
    }

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

    	ContainerRect contenedor = new ContainerRect(10);

        Coordenada a1 = leerCoordenada(sc, "Ingrese una esquina del 1er rectángulo: ");
        Coordenada a2 = leerCoordenada(sc, "Ingrese la esquina opuesta del 1er rectángulo: ");
        Coordenada b1 = leerCoordenada(sc, "Ingrese una esquina del 2do rectángulo: ");
        Coordenada b2 = leerCoordenada(sc, "Ingrese la esquina opuesta del 2do rectángulo: ");

        Rectangulo A = new Rectangulo(a1, a2);
        Rectangulo B = new Rectangulo(b1, b2);

        contenedor.addRectangulo(A);
        contenedor.addRectangulo(B);

        mostrarRectangulo("A", A);
        mostrarRectangulo("B", B);

        if (Verificador.esSobrePos(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo r = rectanguloSobre(A, B);
            System.out.println("Area de sobreposicion = " + r.calculoArea());
        } else if (Verificador.esJunto(A, B)) {
            System.out.println("Rectangulos A y B se juntan");
        } else {
            System.out.println("Rectangulos A y B son disjuntos");
        }
        
        System.out.println("\nContenido del contenedor:");
        System.out.println(contenedor);

        sc.close();
    }
}