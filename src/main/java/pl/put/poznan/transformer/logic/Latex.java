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
        logger.debug(Arrays.toString(text));
        StringBuilder wynik = new StringBuilder();
        int kk = text.length;
        for(int i = 0; i < kk  ; i++)
        {
            if(text[i].length() == 1){
                for (String aChar : chars) {
                    if (text[i].equals(aChar)) {
                        text[i] = "" + "/" + text[i];


                    }



                }

            }







        }

        logger.debug(Arrays.toString(text));
        transforms = String.join(" ", text);

        return transforms.toString();
    }
}