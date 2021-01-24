package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Arrays;

public class ShortcutToString extends TextTransformer{
    public ShortcutToString(String[] transforms, int i){
        super(transforms,i);
    }

    private static final Logger logger = LoggerFactory.getLogger(ShortcutToString.class);

    @Override
    public String transform(String transforms){
        transforms = super.transform(transforms);
        String[] text = transforms.split(" ");

        logger.debug(Arrays.toString(text));
        for(int i = 0; i < text.length; i++)
        {

            if(text[i].equals("itp.")  || text[i].equals("Itp.")) text[i] = text[i].replace("tp.", " tym podobne");
            if(text[i].equals("m.in.") || text[i].equals("M.in.")) text[i] = text[i].replace(".in.", "iędzy innymi");
            if(text[i].equals("np.") || text[i].equals("Np.")) text[i] = text[i].replace("p.", "a przykład");

        }
        logger.debug(Arrays.toString(text));
        transforms = String.join(" ", text);
        return transforms;
    }
    @Override
    public void setTransformation(Transformer transformation){
        super.setTransformation(transformation);
    }
}