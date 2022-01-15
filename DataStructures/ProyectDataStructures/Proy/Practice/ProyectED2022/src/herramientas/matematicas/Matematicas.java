package herramientas.matematicas;

/**
 *
 * @author Clase ED
 */
public class Matematicas {
    private static double gaussiana(double x,double media,double desv){
        double numerador = Math.exp(-(Math.pow(x-media,2))/(2*Math.pow(desv,2)));
        return (numerador)/(Math.PI*Math.sqrt(2*Math.PI));
    }
}
