package pypooeje1;

public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private static int numRec = 0;

    public ContainerRect(int n) {
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = new Rectangulo(r.getEsquina1(), r.getEsquina2());
            distancias[numRec] = Coordenada.distancia(r.getEsquina1(), r.getEsquina2());
            areas[numRec] = r.calculoArea();
            numRec++;
        } else {
            System.out.println("Ya no es posible guardar más rectángulos.");
        }
    }

    public static int getNumRec() {
        return numRec;
    }

    @Override
    public String toString() {
        String resultado = "Rectangulo | Coordenadas | Distancia | Area\n";
        
        for (int i = 0; i < numRec; i++) {
            resultado += (i + 1) + "     "
                    + rectangulos[i] + "   "
                    + String.format("%.3f", distancias[i]) + "     "
                    + String.format("%.2f", areas[i]) + "\n";
        }
        
        return resultado;
    }
}