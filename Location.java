
/**
 * Modela una ubicación en una ciudad formada por una cuadrícula
 * bidimensional mediante coordenadas (x, y).
 * @author David J. Barnes y Michael Kölling
 * @author Clases DP
 * @version 2026.10.13
 */
public class Location
{
    // ==================================================
    // ATRIBUTOS
    // ==================================================
    /**
     * Coordenada horizontal de la ubicación.
     */
    private int x;
    /**
     * Coordenada vertical de la ubicación.
     */
    private int y;
    // ==================================================
    // CONSTRUCTOR
    // ==================================================

    /**
     * Modela una ubicación en la ciudad.
     * @param x Coordenada x. Debe ser no negativa.
     * @param y Coordenada y. Debe ser no negativa.
     * @throws IllegalArgumentException Si una coordenada es negativa.
     */
    public Location(int x, int y)
    {
        if(x < 0) {
            throw new IllegalArgumentException(
                        "Coordenada x negativa: " + x);
        }
        if(y < 0) {
            throw new IllegalArgumentException(
                        "Coordenada y negativa: " + y);
        }
        this.x = x;
        this.y = y;
    }
    // ==================================================
    // GETTERS
    // ==================================================
    /**
     * @return La coordenada x.
     */
    public int getX()
    {
        return x;
    }

    /**
     * @return La coordenada y.
     */
    public int getY()
    {
        return y;
    }
     // ==================================================
    // METODOS
    // ==================================================
    /**
     * Genera la siguiente ubicación a visitar en línea recta
     * hacia el destino.
     * @param destino La ubicación a la que queremos llegar.
     * @return La siguiente ubicación, un paso más cerca del destino.
     * Devuelve el destino si ya estamos en él.
     * @throws NullPointerException si la localización de destino es null.
     */
    public Location siguienteUbicacion(Location destino)
    {
         if(destino == null) {
        throw new NullPointerException(
              "La localizacion de destino no puede ser null");
        }
        int nuevaX ,nuevaY;
        // Avanzamos o retrocedemos en el eje X o no nos movemos
        if(this.x == destino.x ){
           nuevaX= this.x ;
        
        }else if (this.x< destino.x){
            nuevaX = this.x + 1;   
        } else {
            nuevaX = this.x - 1;
        }
        // Avanzamos o retrocedemos en el eje Y o no nos movemos
         if(this.y == destino.y ){
           nuevaY= this.y ;
        
        }else if (this.y< destino.y){
            nuevaY = this.y + 1;   
        } else {
            nuevaY = this.y - 1;
        }
        Location location = new Location(nuevaX,nuevaY);
        return  location;        
    }

    /**
     * Determina el número de movimientos necesarios para llegar
     * desde esta ubicación hasta el destino, utilizando la
     * distancia de Chebyshev.
     * (El máximo de las diferencias absolutas de las coordenadas).
     * @throws NullPointerException si la localización de destino es null.
     * @param destino La ubicación de destino.
     * @return El número de pasos necesarios.
     */
    public int distancia(Location destino)
    { 
        if(destino == null) {
        throw new NullPointerException(
              "La localizacion de destino no puede ser null");
       }
       int distancia;
       int diferenciaX = destino.x - this.x; 
       int diferenciaY= destino.y - this.y;
       // Si la diferencia es negativa, la convertimos en positiva.
       if(diferenciaX<0){
          diferenciaX=diferenciaX*-1;
        }
       if(diferenciaY<0){
           diferenciaY=diferenciaY*-1;
        }
       // Comparamos las dos diferencias y nos quedamos con la mayor. 
        if(diferenciaX<diferenciaY){
        distancia=diferenciaY;
        }else if(diferenciaX>diferenciaY){
        distancia=diferenciaX;
       }else{
        distancia=diferenciaX;//Si son iguales las ubicaciones
        }
        
       
         return distancia;
    }

    /**
     * Implementa la igualdad entre ubicaciones.
     * @param otro El objeto con el que se compara.
     * @return true si el otro objeto es una ubicación y tiene
     * las mismas coordenadas x e y; false en caso contrario.
     */
    @Override
    public boolean equals(Object otro)
    { boolean resultado;
     // Si ambos objetos son el mismo, son iguales
    if (this == otro )  {
       resultado = true;
    }else if (otro==null){
       resultado= false;// Un objeto null nunca es igual a esta ubicación

    } else if (!(otro instanceof Location)){
       resultado = false;
    }else{
    // Convertimos el objeto para acceder a sus coordenadas
     Location otra = (Location) otro;
    
     resultado = this.x==otra.x && this.y==otra.y;
     }   
        return resultado;
    }
    /**
     * Genera un código hash para la ubicación.
     * Utiliza los 16 bits superiores para el valor de y
     * y los 16 bits inferiores para el valor de x.
     *
     * @return El código hash de la ubicación.
     */
    @Override
    public int hashCode()
    {
        return (y << 16) + x;
    }
    
    /**
     * @return Una representación de la ubicación con el formato "x-y".
     */
    @Override
   public String toString()
   {
    return getX() + "-" + getY();
   }

}
