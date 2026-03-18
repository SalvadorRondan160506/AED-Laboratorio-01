import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // para a
        System.out.print("Ingrese una esquina del 1er rectangulo: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Ingrese la esquina opuesta del 1er rectángulo: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        Rectangulo A = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));

        // para b
        System.out.print("Ingrese una esquina del 2do rectangulo: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        System.out.print("Ingrese la esquina opuesta del 2do rectangulo: ");
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();

        Rectangulo B = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));


        System.out.println("\nRectangulo A = (" + A.getEsquinaSuperiorIzquierda() + ", " + A.getEsquinaInferiorDerecha() + ")");
        System.out.println("Rectangulo B = (" + B.getEsquinaSuperiorIzquierda() + ", " + B.getEsquinaInferiorDerecha() + ")");

        if (Verificador.esSobrePos(A, B)) {

            System.out.println("Rectangulos A y B se sobreponen.");

            // calcula area sobreposicion
            double x1i = Math.max(A.getEsquinaSuperiorIzquierda().getX(), B.getEsquinaSuperiorIzquierda().getX());
            double y1i = Math.max(A.getEsquinaInferiorDerecha().getY(), B.getEsquinaInferiorDerecha().getY());

            double x2i = Math.min(A.getEsquinaInferiorDerecha().getX(), B.getEsquinaInferiorDerecha().getX());
            double y2i = Math.min(A.getEsquinaSuperiorIzquierda().getY(), B.getEsquinaSuperiorIzquierda().getY());

            double area = Math.abs((x2i - x1i) * (y2i - y1i));

            System.out.println("Area de sobreposicion = " + area);

        }
        else if (Verificador.esJunto(A, B)) {
            System.out.println("Rectangulos A y B se juntan");
        }
        else if (Verificador.esDisjunto(A, B)) {
            System.out.println("Rectangulos A y B son disjuntos");
        }

        sc.close();
    }
}