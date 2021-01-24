package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextTransformerTest {
    @Test
    public void testKonstruktorThrowsTransformationNotFoundException(){
        Assertions.assertThrows(TransformationNotFoundException.class, ()->{new TextTransformer(new String[]{"tekst"});});
    }
}