package pl.put.poznan.transformer.logic;

/**
 * Interfejs z którego implementują (przez TextTransformer) wszystkie klasy transformujące tekst
 */

public interface Transformer {
    /**
     * metoda do zmiany tekstu
     * @param text tekst do zmienienia
     * @return zmieniony tekst
     */
    String transform(String text);
}
