package pl.put.poznan.transformer.logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ReactiveAdapterRegistry;


import java.util.Arrays;

/**
 * Klasa implementująca metodę do zmiany liczb zmiennoprzzcinkowych na słowa
 */

public class Dzies extends TextTransformer{
    
    public Dzies(String[] transforms, int i){
        super(transforms,i);
    }


    private static final Logger logger = LoggerFactory.getLogger(Dzies.class);
    @Override
    public String transform(String transforms){
        transforms = super.transform(transforms);
        String[] text = transforms.split(" ");
        String ww = "";
        logger.debug(Arrays.toString(text));
        for(int i = 0; i < text.length; i++)
        {
            if (Dzies.floating(text[i])){
                ww = Dzies.numero(text[i]);
                text[i] = ww;
            }
        }
        logger.debug(Arrays.toString(text));
        transforms = String.join(" ", text);
        transforms = transforms.trim().replaceAll(" +", " ");
        return transforms;
    }


    private static boolean floating(String data) {
        int dot = 0;
        boolean foundLeDigit = false;
        for (char c : data.toCharArray()) {
            int jd = Character.compare(c, '.');


            if(!Character.isDigit(c) && jd!=0){
                return false;
            }
            if ((jd ==0) && (dot ==0)) {
                dot = dot +1;
                continue;
            }
            if ((jd ==0) && (dot ==1)) {
                return false;
            }



        }
        if(dot == 0) {
            return false;
        }
        return true;
}
    private static String numero(String data){
        String[] nazwaJednosci = {"", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
        String[] nazwaNastki = {"", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście",
                "siedemnaście", "osiemnaście", "dziewietnaście"};
        String[] nazwaDziesiatki = {"", "dziesięć", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt",
                "sześćdziesiąt", "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"};
        String[] nazwaSetki = {"", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset", "osiemset",
                "dziewięćset"};
        String [] nazwaogolnie = {"dziesiąt", "setn", "tysięczn"};
        String [] konczowka = {"e", "ych"};
        String[] transform = data.split("\\.");
        int konc = 0 ;
        if(transform[0].compareTo("") == 0){
            transform[0] = "0";
        }
        if(transform[1].compareTo("") == 0){
            transform[1] = "0";
        }
        int len = transform[1].length();

        String wynik = "";
        int numbero_uno = Integer.parseInt(transform[0]);
        if(numbero_uno > 10 && numbero_uno <20){
            wynik = nazwaNastki[numbero_uno%10] + " ";

        }
        else{
        int res1 = numbero_uno%10;
        if (numbero_uno > 0) {
            int setki = (numbero_uno / 100);
            numbero_uno = numbero_uno - setki * 100;
            //System.out.print("\n" + setki + "\n");

            wynik = wynik + nazwaSetki[setki] + " ";
        }

        if (numbero_uno > 0) {
            int dzies = (numbero_uno / 10);
            numbero_uno = numbero_uno - dzies * 10;
            wynik = wynik + nazwaDziesiatki[dzies] + " ";

        }
        if (numbero_uno > 0) {
            int jedn = (numbero_uno);
            numbero_uno = numbero_uno - jedn ;
            wynik = wynik + nazwaJednosci[jedn] + " ";

        }}
        int boolf = 0;
        String wynik2 = "";
        int numbero_dos = Integer.parseInt(transform[1]);
        if(numbero_dos ==0){
            boolf = 1;
        }
        int res2 = numbero_dos%10;
        if(numbero_dos > 10 && numbero_dos <20){
            wynik2 = nazwaNastki[numbero_dos%10] + " ";

        }
        else{
        if (numbero_dos > 0) {
            int setki2 = (numbero_dos / 100);
            numbero_dos = numbero_dos - setki2 * 100;
            //System.out.print("\n" + setki + "\n");

            wynik2 = wynik2 + nazwaSetki[setki2] + " ";
            konc = setki2;
        }

        if (numbero_dos > 0) {
            int dzies2 = (numbero_dos / 10);
            numbero_dos = numbero_dos - dzies2 * 10;
            wynik2 = wynik2 + nazwaDziesiatki[dzies2] + " ";
            konc = dzies2;
        }
        if (numbero_dos > 0) {
            int jedn2 = (numbero_dos);
            numbero_dos = numbero_dos - jedn2 ;
            wynik2 = wynik2 + nazwaJednosci[jedn2] + " ";
            konc = jedn2;

        }}
        if (boolf ==1){
            wynik = wynik;
        }
        else{
        if(wynik.compareTo("") == 0) {


            if ((konc == 2 || konc == 3 || konc == 4) && res2 !=0) {
                wynik = wynik2 + nazwaogolnie[len - 1] + konczowka[0];
            } else {
                wynik = wynik2 + nazwaogolnie[len - 1] + konczowka[1];
            }
        }
        else{
            if ((konc == 2 || konc == 3 || konc == 4) && res2 !=0) {
                wynik = wynik + "i " + wynik2 + nazwaogolnie[len - 1] + konczowka[0];
            } else {
                wynik = wynik + "i " + wynik2 + nazwaogolnie[len - 1] + konczowka[1];
            }
        }


    }
        return(wynik);
    }

}











