package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Latex extends TextTransformer{
    public Latex(String[] transforms, int i){
        super(transforms,i);
    }

    private static final Logger logger = LoggerFactory.getLogger(Latex.class);

    @Override
    public String transform(String transforms){
        transforms = super.transform(transforms);
        String[] text = transforms.split(" ");
        String[] chars = {"#" ,"$" ,"%" ,"&", "~" ,"_","^",  "{", "}"};
        List<String> namesList = Arrays.asList( "#" ,"$" ,"%" ,"&", "~" ,"_","^",  "{", "}");
        ArrayList<String> chrr = new ArrayList<String>();
        chrr.addAll(namesList);
        logger.debug(Arrays.toString(text));

        int kk = text.length;



        for(int i = 0; i < kk  ; i++) {
            String ww = "";
            for (char c : text[i].toCharArray()) {
                String s = String.valueOf(c);
                boolean cont = chrr.contains(s);
                if (cont) {
                    ww = ww + "\\" + c;
                }
                else{
                    ww = ww + c;
                }
                    }
            text[i] = ww;




        }
        String wynik = "";
        for (String s : text) {
            wynik = wynik + " " + s;


        }




        //wynik  = wynik.replaceAll("\\\\" , "\\");
        System.out.print(wynik);
        logger.debug(Arrays.toString(text));
        transforms = String.join(">", text);


        return (wynik);
    }
}