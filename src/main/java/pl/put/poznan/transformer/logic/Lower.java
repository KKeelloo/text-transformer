package pl.put.poznan.transformer.logic;

public class Lower extends TextTransformer{
    public Lower(String[] transforms, int i){
        super(transforms,i);
    }

    @Override
    public String transform(String text){
        text = super.transform(text);
        return text.toLowerCase();
    }
}
