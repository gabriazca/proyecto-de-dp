import java.util.Comparator;

/**
 * Compara dos objetos {@link Dock} según tres criterios:
 * velocidad de carga decreciente, tarifa de carga creciente
 * e identificador en orden ascendente.
 * @author DP Clasess
 * @version 2026.10.13
 */
public class ComparatorDocks implements Comparator<Dock>
{
    /**
     * Compara dos objetos {@link Dock} para establecer un orden.
     * @param c1 El primer dock que se va a comparar.
     * @param c2 El segundo dock que se va a comparar.
     * @return Un número negativo, cero o positivo según el orden
     * establecido por los tres criterios de comparación.
     */
    @Override
    public int compare(Dock c1, Dock c2) {
        int resultado;

        // Primer criterio: velocidad de carga decreciente.
        // Se invierte el orden para que la velocidad mayor aparezca primero.
        resultado = Integer.compare(
            c2.getChargingSpeed(), c1.getChargingSpeed());

        // Segundo criterio: si las velocidades son iguales,
        // se compara la tarifa de menor a mayor.
        if (resultado == 0) {
            resultado = Float.compare(
                c1.getChargingFee(), c2.getChargingFee());
        }

        // Tercer criterio: si también empatan las tarifas,
        // se comparan los identificadores en orden creciente.
        if (resultado == 0) {
            resultado = c1.getIdDock().compareTo(c2.getIdDock());
        }

        // Devuelve el resultado de la comparación.
        return resultado;
    }
}