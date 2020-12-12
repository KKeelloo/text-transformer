package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer implements Transformer{

    private Transformer transformation;

    public TextTransformer(String[] transforms){

        switch (transforms[0]) {
            case "upper":
                transformation = new Upper(transforms, 1);
                break;
            case "lower":
                transformation = new Lower(transforms, 1);
                break;
            default:
                throw new TransformationNotFoundException(transforms[0]);
        }
    }
    public TextTransformer(String[] transforms, int i){
        if(i < transforms.length) {
            switch (transforms[i]) {
                case "upper":
                    transformation = new Upper(transforms, i + 1);
                    break;
                case "lower":
                    transformation = new Lower(transforms, i + 1);
                    break;
                default:
                    throw new TransformationNotFoundException(transforms[i]);
            }
        }
    }

    @Override
    public String transform(String text){
        // of course, normally it would do something based on the transforms
        if (transformation != null)
            return transformation.transform(text);
        return text;
    }
}
