package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class big_or_not_to_big extends TextTransformer{
    public big_or_not_to_big(String[] transforms, int i){
        super(transforms,i);
    }

    private static final Logger logger = LoggerFactory.getLogger(ShortcutToString.class);
    public static List lastIndexOfUCL(String str) {
        List ww = new ArrayList();
        for(int i=str.length()-1; i>=0; i--) {
            if(Character.isUpperCase(str.charAt(i))) {
                ww.add(i);
            }
        }
        return (ww);
    }
    public static String reverse_cap(String str , List index){
        str = str.toLowerCase();
        char[] c_arr = str.toCharArray();

        for(int i = 0 ; i < index.size() ; i++){
            char ii =  c_arr[(int) index.get(i)];
            ii = Character.toUpperCase(ii);
            c_arr[(int) index.get(i)] = ii;

        }
        String s = new String(c_arr);
        //System.out.println(s);

        return s;
    }


    @Override
    public String transform(String transforms){
        transforms = super.transform(transforms);
        String[] text = transforms.split(" ");

        logger.debug(Arrays.toString(text));
        for(int i = 0; i < text.length; i++)
        {
            StringBuffer sb = new StringBuffer(text[i]);
            sb.reverse();
            String reversed = new String(sb);


            ArrayList gg = (ArrayList) big_or_not_to_big.lastIndexOfUCL(text[i]);
            text[i] = big_or_not_to_big.reverse_cap(reversed,gg);

        }
        logger.debug(Arrays.toString(text));
        transforms = String.join(" ", text);
        return transforms;
    }
}