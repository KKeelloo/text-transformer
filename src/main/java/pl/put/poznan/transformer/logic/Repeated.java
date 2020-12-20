package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repeated extends TextTransformer{
    public Repeated(String[] transforms, int i){
        super(transforms,i);
    }

    private static final Logger logger = LoggerFactory.getLogger(Repeated.class);

    @Override
    public String transform(String transforms){
        transforms = super.transform(transforms);
        String[] text = transforms.split(" ");

        logger.debug(Arrays.toString(text));
        int kk = text.length;
        for(int i = 0; i < kk - 1 ; i++)
        {
            if((i+1) == kk){
                break;
            }
            if(text[i].equals(text[i+1])) {
                List<String> list = new ArrayList<String>(Arrays.asList(text));
                list.remove(i);
                text = list.toArray(new String[0]);
                i = i - 1;
                kk=kk-1;
            }


        }
        logger.debug(Arrays.toString(text));
        transforms = String.join(" ", text);
        return transforms;
    }
}