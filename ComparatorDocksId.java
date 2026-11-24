import java.util.*;

/**
 * Compara dos objetos {@link Dock} según su cadena de texto **ID**
 * en orden **ascendente**.
 * Normalmente se utiliza como criterio final para desempatar
 * en una ordenación con varios criterios.
 * @author DP Clasess
 * @version 2026.10.13
 */
public class ComparatorDocksId implements Comparator<Dock>
{
    /**
     * Compara sus dos argumentos {@link Dock} para establecer un orden.
     * La comparación se basa en el orden lexicográfico de sus identificadores.
     * @param c1 El primer dock que se va a comparar.
     * @param c2 El segundo dock que se va a comparar.
     * @return Un número negativo, cero o positivo según si el identificador
     * del primer dock es lexicográficamente menor, igual o mayor que el segundo.
     */
    public int compare(Dock c1, Dock c2) {
        // TODO: Completar este código
        return 0;
    }
}