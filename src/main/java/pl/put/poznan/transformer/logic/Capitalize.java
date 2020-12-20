package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Klasa implementująca metodę do zmiany tekstu na dużą pierwszą w każdym słowie
 */

public class Capitalize extends TextTransformer{
    /**
     * Logger do loggowania
     */
    private static final Logger logger = LoggerFactory.getLogger(Capitalize.class);

    /**
     * Konstruktor, prarametry przekazywane do konstruktora TextTransformer
     *
     * @param transforms transformacje do wykonania
     * @param i indeks transformacji wcześniejszej
     */

    public Capitalize(String[] transforms, int i){
        super(transforms,i);
    }

    /**
     * Wywołuje wcześniejszą transformację i wykonuje transformację zmieniającą tekst na kapitałki
     *
     * @param text tekst do transformacji
     * @return tekst w kapitałkach
     */

    @Override
    public String transform(String text){
        text = super.transform(text);
        logger.info(text);
        String[] text_splitted = text.split(" ");

        for (int i = 0; i < text_splitted.length; i++) {
            text_splitted[i] = text_splitted[i].substring(0,1).toUpperCase() + text_splitted[i].substring(1).toLowerCase();
        }

        text = String.join(" ", text_splitted);
        logger.info(text);
        return text;
    }
}
