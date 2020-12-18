package pl.put.poznan.transformer.logic;

/**
 * Klasa implementująca metodę do zmiany tekstu na małe litery
 */

public class Lower extends TextTransformer{

    /**
     * Konstruktor, prarametry przekazywane do konstruktora TextTransformer
     * @param transforms transformacje do wykonania
     * @param i indeks transformacji wcześniejszej
     */

    public Lower(String[] transforms, int i){
        super(transforms,i);
    }

    /**
     * Wywołuje wcześniejszą transformację i wykonuje transformację zmieniającą litery tekstu na małe.
     * @param text tekst do transformacji
     * @return tekst w małych literach
     */

    @Override
    public String transform(String text){
        text = super.transform(text);
        return text.toLowerCase();
    }
}
