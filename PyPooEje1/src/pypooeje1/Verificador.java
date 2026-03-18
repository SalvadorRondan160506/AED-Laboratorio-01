package pypooeje1;

public class Verificador {

    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        double xIzq = Math.max(r1.getMinX(), r2.getMinX());
        double xDer = Math.min(r1.getMaxX(), r2.getMaxX());
        double yInf = Math.max(r1.getMinY(), r2.getMinY());
        double ySup = Math.min(r1.getMaxY(), r2.getMaxY());

        return (xIzq < xDer) && (yInf < ySup);
    }

    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        double xIzq = Math.max(r1.getMinX(), r2.getMinX());
        double xDer = Math.min(r1.getMaxX(), r2.getMaxX());
        double yInf = Math.max(r1.getMinY(), r2.getMinY());
        double ySup = Math.min(r1.getMaxY(), r2.getMaxY());

        boolean sobre = (xIzq < xDer) && (yInf < ySup);
        if (sobre) return false;

        return (xIzq <= xDer) && (yInf <= ySup);
    }

    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}