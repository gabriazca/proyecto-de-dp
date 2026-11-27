import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * Modela una estación de carga de vehículos eléctricos.
 * Una estación de carga contiene varias unidades {@link Dock}.
 * @author Clases DP
 * @version 2026.10.13
 */
public class BikeStation
{
    // ==================================================
    // ATRIBUTOS
    // ==================================================
    /**
     * Identificador único de la estación, compuesto por 4 caracteres:
     * los 2 primeros son letras que indican la ciudad a la que pertenece
     * la estación y los 2 últimos son dígitos que identifican la estación
     * dentro de dicha ciudad.
     * Ejemplo: CC01.
      */
    private String idStation ;
    /**
     * Posición de la estación  en  la ciudad.
     */
    private Location location;
    /**
     * Colección de docks de la estación, ordenados según
     * su velocidad de carga, tarifa e identificador
     */
    private Set<Dock>   docks;
    // ==================================================
    // CONSTRUCTORES
    // ==================================================

    /**
     * Constructor de los objetos de la clase BikeStation.
     *  Inicializa la colección de docks vacía.
     */
    public BikeStation()
    {
        docks = new TreeSet<>(new ComparatorDocks());
    }

    /**
     * Constructor de los objetos de la clase BikeStation.
     * @param identificador
     * @param ubicacion 
     */
    public BikeStation(String identificador, Location ubicacion)
    {
        if(identificador==null || identificador.length() != 4 ) {
            throw new IllegalArgumentException(
                        "Identificador introducido no valido" + identificador);
        }
        if(ubicacion == null ) {
            throw new   NullPointerException(
                        "Valor no valido de ubicaion");
        }
       idStation = identificador;
       location = ubicacion;
       docks = new TreeSet<>(new ComparatorDocks());
       
    }
    // ==================================================
    // GETTERS y SETTERS
    // ==================================================
    /**
     * @return La coleccion de docks que tiene la estacion
     */
    public Set<Dock> getDocks(){
       return  docks ;
    }
    /**
     * @return El identificador único de la estación de carga.
     */
    public String getIdentificador()
    {
        return idStation;
    }
    /**
     * @return La ubicacion de la estacion.
     */
    public Location getLocation()
    {
        return location;
    }
    /**
     * Obtiene un objeto de tipo Dock de la colección docks.
     * @param identificador Identificador del dock que se desea obtener.
     * @return Un objeto de tipo Dock.
     */
   public Dock getDock(String identificador)
  {
    Dock resultado = null;
    boolean encontrado = false;

    Iterator<Dock> it = docks.iterator();

    while (it.hasNext() && !encontrado) {
        Dock dock = it.next();

        if (dock.getIdDock().equals(identificador)) {
            resultado = dock;
            encontrado = true;
        }
    }

    return resultado;
  }
    
       /**
     * Obtiene el primer {@link Dock} libre que se encuentre en la estación.
     * @return Un {@link Dock} libre.
     * Nota: Se supone que existe al menos un dock libre cuando se llama
     * a este método.
     */
    public Dock getDockLibre()
    { 
     Dock resultado = null;
     boolean encontrado = false;
     
     Iterator<Dock> it = docks.iterator();
     
    while (it.hasNext() && !encontrado){
     Dock dock = it.next();
     
     if(dock.isFree()){
        encontrado=true;
        resultado = dock;
        }}
     return resultado;
    }   
    /**
     * Establece la ubicación actual de la estación de carga.
     * @param ubicacion Dónde se encuentra. No puede ser null.
     * @throws NullPointerException Si la ubicación es null.
     */
    public void setUbicacion(Location ubicacion)
    {
        if(ubicacion == null){
          throw new NullPointerException("Ubicacion no valida a null");
        }
        location=ubicacion;
    }
    // ==================================================
    // METODOS
    // ==================================================
    /**
      * Devuelve el número total de bicicletas recargadas
      * en todos los docks de la estación.
      * @return Número total de bicicletas recargadas.
     */
    public int getNumberEVRecharged()
    {
      int numrecargas = 0;
      for(Dock dock :docks){
        numrecargas= numrecargas + dock.getNumerEVRecharged();
        }
      return numrecargas;
    }
    /**
     * Añade un nuevo {@link Dock} a la estación.
     * @param darsena El nuevo dock.
     * @throws NullPointerException Si el dock es null.
     */
    public void anadirDock(Dock darsena)
    {
     if (darsena == null) {
        throw new NullPointerException("El dock no puede ser null");
    }
        docks.add(darsena);
    }
    /**
    * Implementa la igualdad entre estaciones de bicicletas.
    * @param otro El objeto con el que se compara.
    * @return true si el otro objeto es una estación con el mismo identificador;
    *         false en caso contrario.
    */
    @Override
    public boolean equals(Object otro){
    boolean resultado;
    // Si ambos objetos son el mismo, son iguales
    if (this == otro )  {
       resultado = true;
    }else if (otro==null){
       resultado= false;// Un objeto null nunca es igual a esta estacion

    } else if (!(otro instanceof BikeStation)){
       resultado = false;
    }else{
    // Convertimos el objeto para acceder a su identificador
     BikeStation otra = (BikeStation) otro;
    
     resultado = this.idStation.equals(otra.idStation);
     }   
        return resultado;
    }
   /**
     * Calcula el código hash de la estación.
     * @return El código hash basado en el identificador de la estación.
    */
   @Override
   public int hashCode()
   {
    int resultado;

    resultado = idStation.hashCode();

    return resultado;
    }
    /**
      * Devuelve una representación textual de la estación,
      * incluyendo su identificador, el número de bicicletas
      * recargadas y su localización.
      * @return Una representación textual de la estación.
     */
   @Override
   public String toString()
   {
    return "(BikeStation: " + getIdentificador() + ", "
        + getNumberEVRecharged() + ", " + getLocation() + ")";
   }
    

}