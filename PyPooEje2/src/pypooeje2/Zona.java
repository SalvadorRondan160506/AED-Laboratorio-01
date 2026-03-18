package pypooeje2;

public class Zona {
    private String mineral;
    private double cantidad;
    private double pureza;

    public Zona(String mineral, double cantidad, double pureza) {
        this.mineral = mineral;
        this.cantidad = cantidad;
        this.pureza = pureza;
    }

    public String getMineral() {
        return mineral;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPureza() {
        return pureza;
    }

    public double getValorEconomico() {
        return cantidad * pureza;
    }

    @Override
    public String toString() {
        return "[ " + mineral + ", cantidad: " + cantidad + ", pureza: " + pureza + " ]";
    }
}