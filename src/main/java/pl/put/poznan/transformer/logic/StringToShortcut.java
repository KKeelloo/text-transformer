package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class StringToShortcut extends TextTransformer{

    private Map<String,String> dict;

    public StringToShortcut(String[] transforms, int i){
        super(transforms,i);
        dict = new HashMap<String,String>();
        dict.put("na przykład", "np.");
        dict.put("między innymi", "m.in.");
        dict.put("i tym podobne", "itp.");
    }

    @Override
    public String transform(String text){
        text = super.transform(text);
        String lower = text.toLowerCase();
        String ret = text;
        for(String key : dict.keySet()){
            int index = lower.indexOf(key);
            while (index!=-1){
                ret = ret.substring(0,index)+dict.get(key)+ret.substring(index+key.length());
                lower = ret.toLowerCase();
                index = lower.indexOf(key);
            }
        }
        return ret;
    }
}
