package pl.put.poznan.transformer.logic;

public class Upper extends TextTransformer{
    public Upper(String[] transforms, int i){
        super(transforms,i);
    }

    @Override
    public String transform(String text){
        text = super.transform(text);
        return text.toUpperCase();
    }
}
