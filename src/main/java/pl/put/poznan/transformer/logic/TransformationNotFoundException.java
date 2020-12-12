package pl.put.poznan.transformer.logic;

public class TransformationNotFoundException extends RuntimeException{

    TransformationNotFoundException(String transformation){
        super("Could not find transformation " + transformation);
    }
}
