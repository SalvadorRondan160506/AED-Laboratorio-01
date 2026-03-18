public class ContainerRect {

    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;

    public static int numRec = 0;

    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    public void addRectangulo(Rectangulo r) {

        if (numRec < n) {

            rectangulos[numRec] = r;

            distancias[numRec] = Coordenada.distancia(
                    r.getEsquina1(),
                    r.getEsquina2()
            );

            areas[numRec] = r.calculoArea();

            numRec++;

        } else {
            System.out.println("No se pueden almacenar mas rectangulos.");
        }
    }

    @Override
    public String toString() {

        String s = "Rectangulo\tCoordenadas\t\tDistancia\tArea\n";

        for (int i = 0; i < numRec; i++) {

            s += (i + 1) + "\t(" +
                    rectangulos[i].getEsquinaSuperiorIzquierda() + ", " +
                    rectangulos[i].getEsquinaInferiorDerecha() + ")\t" +
                    String.format("%.3f", distancias[i]) + "\t\t" +
                    String.format("%.2f", areas[i]) + "\n";
        }

        return s;
    }
}