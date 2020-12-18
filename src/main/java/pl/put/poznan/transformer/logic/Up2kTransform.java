package pl.put.poznan.transformer.logic;


import java.util.Arrays;

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
     * metoda sprawdzacjąca czy podany string jest liczbą
     *
     * @param str
     * @return true gdy parametr to liczba lub false gdy nie jest liczbą
     */
    public static boolean isNumeric(final String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metoda sluzaca do transformacji liczby na tekst
     *
     * @param text liczba podana przez uzytkownika wczytywana jako String
     * @return text zwraca liczbe zamieniona na tekst
     */
    @Override
    public String transform(String text){
        text = super.transform(text);

        String[] transform = text.split(" ");

        for(int i = 0; i < transform.length; i++)
        {
            if(isNumeric(transform[i])){

                number = Integer.parseInt(transform[i]);
                transform[i] = "";

                //JEDNOSCI
                jednosci = number%10;
                System.out.println(jednosci);
                transform[i] = nazwaJednosci[jednosci];

                number -= jednosci;

                //DZIESIATKI
                dziesiatki = number%100;
                System.out.println(dziesiatki);

                if(dziesiatki == 10 && jednosci > 0){
                    transform[i] = nazwaNastki[jednosci];
                }else if (dziesiatki != 0 && jednosci != 0){
                    transform[i] = nazwaDziesiatki[dziesiatki/10] + " " + transform[i];
                }else{
                    transform[i] = nazwaDziesiatki[dziesiatki/10];
                }

                number -= dziesiatki;

                //SETKI
                setki = number%1000;
                System.out.println(setki);
                if(setki != 0 && dziesiatki == 0 && jednosci == 0){
                    transform[i] = nazwaSetki[setki / 100];
                }else if(setki != 0){
                    transform[i] = nazwaSetki[setki / 100] + " " + transform[i];
                }

            }

        }
        text = String.join(" ", transform);

        return text;
    }
}