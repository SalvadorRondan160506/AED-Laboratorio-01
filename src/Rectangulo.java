import java.util.*;

public class Rectangulo {

    private Coordenada esquina1;
    private Coordenada esquina2;

    public Rectangulo(Coordenada c1, Coordenada c2) {
        setEsquina1(c1);
        setEsquina2(c2);
    }

    public Rectangulo (int x, int y){
        this.esquina1=new Coordenada(0,0);
        this.esquina2=new Coordenada(x,y);
    }

    public void setEsquina1(Coordenada esquina1) {

        this.esquina1 = esquina1;
    }

    public void setEsquina2(Coordenada esquina2) {

        this.esquina2 = esquina2;
    }

    public Coordenada getEsquina1() {

        return this.esquina1;
    }

    public Coordenada getEsquina2() {

        return this.esquina2;
    }

    public Coordenada getEsquinaSuperiorIzquierda(){
        double x = Math.min(esquina1.getX(), esquina2.getX());
        double y = Math.min(esquina1.getY(), esquina2.getY());
        return new Coordenada(x,y);
    }

    public Coordenada getEsquinaInferiorDerecha(){
        double x = Math.max(esquina1.getX(), esquina2.getX());
        double y = Math.max(esquina1.getY(), esquina2.getY());
        return new Coordenada(x,y);
    }

    public double calculoArea() {
        double longitud = Math.abs(esquina2.getX() - esquina1.getX());
        double anchura = Math.abs(esquina2.getY() - esquina1.getY());
        return longitud * anchura;
    }

    @Override
    public String toString() {

        String s= "(["+esquina1.getX() + ", " + esquina1.getY() + "],[" + esquina2.getX()+ ", "+esquina2.getY()+")]";

        return s;
    }
}