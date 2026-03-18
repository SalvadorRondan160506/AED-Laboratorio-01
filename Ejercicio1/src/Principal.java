import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ContainerRect contenedor = new ContainerRect(10);

        for (int i = 0; i < 2; i++) {

            System.out.print("Ingrese una esquina del rectngulo: ");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();

            System.out.print("Ingrese la esquina opuesta del rectangulo: ");
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            Rectangulo r = new Rectangulo(
                    new Coordenada(x1, y1),
                    new Coordenada(x2, y2)
            );

            contenedor.addRectangulo(r);
        }

        System.out.println("\nContenido del contenedor:");
        System.out.println(contenedor);

        sc.close();
    }
}