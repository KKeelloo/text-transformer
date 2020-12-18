package pl.put.poznan.transformer.logic;

/**
 *  Klasa do rzucania wyjątku w przypadku wywołania nieistniejącej transformacji
 */

public class TransformationNotFoundException extends RuntimeException{
    /**
     * Konstruktor klasy
     * @param transformation nazwa nieistniejącej transformacji
     */
    TransformationNotFoundException(String transformation){
        super("Could not find transformation " + transformation);
    }
}
