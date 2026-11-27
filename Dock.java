import java.util.Set;
import java.util.LinkedHashSet;

/**
 * Modela una unidad de carga dentro de una {@link BikeStation}.
 * Registra sus capacidades de carga, su tarifa y las bicicletas
 * eléctricas que ha recargado.
 * @author David J. Barnes and Michael Kölling
 * @author DP classes
 * @version 2026.10.13
 */
public class Dock
{
    // ==================================================
    // ATRIBUTOS
    // ==================================================

    /**
      * Identificador único del dock, compuesto por 7 caracteres:
      * los 4 primeros corresponden al identificador de la estación
      * (2 letras que indican la ciudad y 2 dígitos que identifican
      * la estación), seguidos del carácter '_' y de 2 dígitos
      * que identifican el dock dentro de dicha estación.
      * Ejemplo: CC01_02.
     */
    private String idDock;

    /**
     * Velocidad de carga del dock, expresada en Wh.
     */
    private int chargingSpeed;

    /**
     * Tarifa de carga del dock, expresada en euros.
     */
    private float chargingFee;

    /**
     * Conjunto de bicicletas eléctricas que han sido recargadas
     * en el dock. Se mantiene el orden de llegada de las bicicletas.
     */
    private Set<ElectricBike> bikesRecharged;

    /**
     * Cantidad total de dinero recaudado por el dock, expresada en euros.
     */
    private float amountCollected;

    /**
     * Indica si el dock está libre para recargar una bicicleta.
     */
    private boolean free;

    // ==================================================
    // CONSTRUCTOR
    // ==================================================

    /**
     * Constructor de objetos de la clase Dock.
     *
     * @param id Identificador del dock.
     * @param speed Velocidad de carga del dock.
     * @param fee Tarifa de carga del dock.
     */
    public Dock(String id, int speed, float fee)
    {
     if(id == null || id.length() != 7 ) {
            throw new IllegalArgumentException(
                        "Identificador introducido no valido" + id);
        }
     if (speed < 0){
          throw new IllegalArgumentException(
                        "Velocidad no valida y negativa: " + speed);
        }
     if (fee < 0) {
        throw new IllegalArgumentException(
                    "Tarifa no válida y negativa: " + fee);
      }
     
       idDock = id;
       chargingSpeed = speed;
       chargingFee=fee;
       bikesRecharged = new LinkedHashSet<>();
       amountCollected=0;
       free = true;
       
    }
    // ==================================================
    // GETTERS
    // ==================================================
    /**
     * Devuelve el identificador único del dock.
     *
     * @return El identificador del dock.
     */
    public String getIdDock()
    {
        return idDock;
    }

    /**
     * Devuelve la velocidad de carga del dock, expresada en Wh.
     *
     * @return La velocidad de carga del dock.
     */
    public int getChargingSpeed()
    {
        return chargingSpeed;
    }

    /**
     * Devuelve la tarifa de carga del dock, expresada en euros.
     *
     * @return La tarifa de carga del dock.
     */
    public float getChargingFee()
    {
        return chargingFee;
    }
    /**
     * Devuelve si el dock está libre para recargar una bicicleta.
     *
     * @return true si el dock está libre, false si está ocupado.
     */
    public boolean isFree()
    {
        return free;
    }
    /**
     * Devuelve el número total de bicicletas eléctricas
     * que han sido recargadas en este dock.
     *
     * @return El número total de bicicletas eléctricas recargadas.
     */
    public int getNumerEVRecharged(){
        int recargas = bikesRecharged.size();
        return recargas;
    }
    // ==================================================
    // METODOS
    // ==================================================
    /**
      * Añade una nueva bicicleta eléctrica a la colección
      * de bicicletas cargadas.
      * @param eb La bicicleta eléctrica que se va a añadir.
      */
    public void addElectricBike(ElectricBike eb) {
    if (eb != null) {
     bikesRecharged.add(eb);
      } 
    }  
    /**
     * Actualiza la cantidad de dinero recaudado por el dock.
     * @param amount La cantidad que se va a añadir a lo recaudado.
     */
    public void updateCollectedAmount(float amount) {
     amountCollected = amountCollected + amount;
    }
    /**
     * Simula el proceso de carga de una bicicleta eléctrica.
     * Aumenta la cantidad de dinero recaudado y registra
     * la bicicleta como recargada.
     *
     * @return La cantidad cobrada por la recarga.
     */
    public float recharge(ElectricBike eb, int wh){
       float coste = wh * chargingFee;

        updateCollectedAmount(coste);
        addElectricBike(eb);
        return coste;
    }
    /**
     * Devuelve una representación textual del dock, incluyendo
     * su identificador, velocidad, tarifa y número de bicicletas
     * eléctricas recargadas.
     *
     * @return Una representación textual del dock.
     */
    public String toString()
    {
        return "(Dock: " + getIdDock() + ", "
        + getChargingSpeed() + "wh, " + getChargingFee() + 
        "€, " + getNumerEVRecharged() + ", " + amountCollected +"€)";
    }
}