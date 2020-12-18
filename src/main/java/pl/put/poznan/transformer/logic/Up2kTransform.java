package pl.put.poznan.transformer.logic;

/**
 * Klasa Up2kTransform sluzaca do transformacji liczb do 999 na tekst
 *
 * @version 1.0
*/

public class Up2kTransform extends TextTransformer{
    private int number, jednosci, dziesiatki, setki;

    String[] nazwaJednosci = {"", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
    String[] nazwaNastki = {"", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście",
            "siedemnaście", "osiemnaście", "dziewietnaście"};
    String[] nazwaDziesiatki = {"", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt",
            "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};
    String[] nazwaSetki = {"", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset",
            "dziewięćset"};

    /**
     * Konstruktor klasy Up2kTransform
     *
     * @param transforms
     * @param i
     */
    public Up2kTransform(String[] transforms, int i){
        super(transforms, i);
    }

    /**
     * Metoda sluzaca do transformacji liczby na tekst
     *
     * @param text liczba podana przez uzytkownika wczytywana jako String
     * @return text zwraca liczbe zamieniona na tekst
     */
    @Override
    public String transform(String text){
        number = Integer.parseInt(text);
        text = "";

        //JEDNOSCI
        jednosci = number%10;
        System.out.println(jednosci);
        text = nazwaJednosci[jednosci];

        number -= jednosci;

        //DZIESIATKI
        dziesiatki = number%100;
        System.out.println(dziesiatki);

        if(dziesiatki == 0){}
        else if(dziesiatki == 10 && jednosci > 0){
            text = nazwaNastki[jednosci];
        }else{
            text = nazwaDziesiatki[dziesiatki/10] + " " + text;
        }

        number -= dziesiatki;

        //SETKI
        setki = number%1000;
        System.out.println(setki);
        if(setki == 0){}
        else {
            text = nazwaSetki[setki / 100] + " " + text;
        }

        return text;
    }
}