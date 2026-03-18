public class Verificador {

    // retorna true si los rectángulos se sobreponen
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {

        if (esJunto(r1,r2)){
            return false;
        }
        Rectangulo recA=new Rectangulo(r1.getEsquinaSuperiorIzquierda(), r1.getEsquinaInferiorDerecha());
        Rectangulo recB=new Rectangulo(r2.getEsquinaSuperiorIzquierda(), r2.getEsquinaInferiorDerecha());

        if (recA.getEsquina1().getX()> recB.getEsquina2().getX() || recB.getEsquina1().getX()>recA.getEsquina2().getX()){
            return false;
        }

        if (recA.getEsquina2().getY()>recB.getEsquina1().getY() || recB.getEsquina2().getY()>recA.getEsquina1().getY()){
            return false;
        }

        return true;
    }

    // retorna true si los rectángulos se juntan
    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {

        boolean compartenBordeEnX=false;
        boolean compartenBordeEnY=false;

        Rectangulo recA=new Rectangulo (r1.getEsquinaSuperiorIzquierda(), r1.getEsquinaInferiorDerecha());
        Rectangulo recB=new Rectangulo (r2.getEsquinaSuperiorIzquierda(), r2.getEsquinaInferiorDerecha());

        //coordenadas de primer rectangfulo
        double ax1=recA.getEsquina1().getX();
        double ay1=recA.getEsquina1().getY();
        double ax2=recA.getEsquina2().getX();
        double ay2=recA.getEsquina2().getY();

        //coordenadade los bordes del segundo rectangulo
        double bx1=recB.getEsquina1().getX();
        double by1=recB.getEsquina1().getY();
        double bx2=recB.getEsquina2().getX();
        double by2=recB.getEsquina2().getY();

        //comprobar si comparten un borde en el eje x
        if (ax2==bx1 || ax1==bx2){
            if(by1 <= ay1 && by1 >= ay2){
                compartenBordeEnX=true;
            }
            if (by2 <= ay1 && by2 >= ay2){
                compartenBordeEnX=true;
            }
        }

        if(ay2==by1 || ay1 ==by2){
            System.out.println("a");
            if(bx1 >= ay1 && by2 >= ay2){
                compartenBordeEnX=true;
            }
            if(bx2 >= ax1 && bx2 <= ax2) {
                compartenBordeEnY=true;
            }
        }

        return (compartenBordeEnX || compartenBordeEnY);

    }

    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}