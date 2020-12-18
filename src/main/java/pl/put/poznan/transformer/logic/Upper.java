package pl.put.poznan.transformer.logic;

/**
 * Klasa implementująca metodę do zmiany tekstu na duże litery
 */

public class Upper extends TextTransformer{

    /**
     * Konstruktor, prarametry przekazywane do konstruktora TextTransformer
     * @param transforms transformacje do wykonania
     * @param i indeks transformacji wcześniejszej
     */

    public Upper(String[] transforms, int i){
        super(transforms,i);
    }

    /**
     * Wywołuje wcześniejszą transformację i wykonuje transformację zmieniającą litery tekstu na duże.
     * Właściwie to wszystkie opisy klas dziedzicząceych z TextTransformer będą prawie takie same.
     * @param text tekst do transformacji
     * @return tekst w dużych literach
     */

    @Override
    public String transform(String text){
        text = super.transform(text);
        return text.toUpperCase();
    }
}
