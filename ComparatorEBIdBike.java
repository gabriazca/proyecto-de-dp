import java.util.*;

/**
 * Compara dos objetos {@link ElectricBike} según su cadena de texto
 * identificadora, en orden ascendente.
 * Puede utilizarse para ordenar listas de bicicletas eléctricas.
 * @author DP Clasess
 * @version 2026.10.13
 */
public class ComparatorEBIdBike implements Comparator<ElectricBike>
{
    /**
     * Compara sus dos argumentos {@link ElectricBike} para establecer
     * un orden.
     * La comparación se basa en el orden lexicográfico de sus identificadores.
     * @param eb1 La primera bicicleta eléctrica que se va a comparar.
     * @param eb2 La segunda bicicleta eléctrica que se va a comparar.
     * @return Un número negativo, cero o positivo según si la matrícula
     * de la primera bicicleta es menor, igual o mayor que la segunda.
     */
    public int compare(ElectricBike eb1, ElectricBike eb2) {
        // TODO: Completar este código
        return 0;
    }
}