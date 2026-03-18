
public class Coordenada {

    private double x;
    private double y;

    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    public void setX(double x) {

        this.x = x;
    }

    public void setY(double y) {

        this.y = y;
    }

    public double getX() {

        return this.x;
    }

    public double getY() {

        return this.y;
    }

    public double distancia(Coordenada c) {
        double x = c.x - this.x;
        double y = c.y - this.x;
        double res= Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        return res;
    }

    public static double distancia(Coordenada c1, Coordenada c2) {
        double x = c2.x - c1.x;
        double y = c2.y - c1.y;
        double res=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        return res;
    }


    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}