package pl.put.poznan.transformer.logic;

/**
 * Klasa będąca podstawą do przetwarzania tekstu.
 * Przetwarzanie następuje od ostatniej trasformacji podaniej w sekwencji do pierwszej.
 */
public class TextTransformer implements Transformer{
    /**
     * transformacja do wykonania
     */
    private Transformer transformation;

    /**
     *
     * Konstruktor, przypisze do pola transformation transformację z indeksu 0 parametru transforms
     *
     * @param transforms tablica Stringów zawierające wszystkie transformacje które należy wykonać
     */

    public TextTransformer(String[] transforms){

        switch (transforms[0]) {
            case "upper":
                transformation = new Upper(transforms, 1);
                break;
            case "lower":
                transformation = new Lower(transforms, 1);
                break;
            case "short2str":
                transformation = new ShortcutToString(transforms, 1);
                break;
            case "str2short":
                transformation = new StringToShortcut(transforms, 1);
                break;
            case "up2k":
                transformation = new Up2kTransform(transforms, 1);
                break;
            case "rep":
                transformation = new Repeated(transforms, 1);
                break;
            case "ix":
                transformation = new big_or_not_to_big(transforms, 1);
                break;
            case "capital":
                transformation = new Capitalize(transforms, 1);
                break;
            default:
                throw new TransformationNotFoundException(transforms[0]);
        }
    }

    /**
     *
     * Konstruktor, przypisze do pola transformation transformację z indeksu i parametru transforms
     *
     * @param transforms tablica Stringów zawierające wszytkie transformacje które należy wykonać
     * @param i wskazuje na indeks wcześniejszej transformacji do wykonania (czyli bliższej końca sekwencji)
     */

    public TextTransformer(String[] transforms, int i){
        if(i < transforms.length) {
            switch (transforms[i]) {
                case "upper":
                    transformation = new Upper(transforms, i + 1);
                    break;
                case "lower":
                    transformation = new Lower(transforms, i + 1);
                    break;
                case "short2str":
                    transformation = new ShortcutToString(transforms, i + 1);
                    break;
                case "str2short":
                    transformation = new StringToShortcut(transforms, i + 1);
                    break;
                case "up2k":
                    transformation = new Up2kTransform(transforms, i + 1);
                    break;
                case "rep":
                    transformation = new Repeated(transforms, i + 1);
                    break;
                case "ix":
                    transformation = new big_or_not_to_big(transforms, i + 1);
                    break;
                case "capital":
                    transformation = new Capitalize(transforms, i + 1);
                    break;
                default:
                    throw new TransformationNotFoundException(transforms[i]);
            }
        }
    }

    /**
     *
     * Wywołuje transformację z pola transformation
     *
     * @param text tekst do transformacji
     * @return String zmieniony przez transformację lub niezmieniony jeśli to pole jest równe null
     */

    @Override
    public String transform(String text){
        if (transformation != null)
            return transformation.transform(text);
        return text;
    }
}
