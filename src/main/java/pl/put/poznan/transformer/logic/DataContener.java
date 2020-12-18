package pl.put.poznan.transformer.logic;

/**
 * Klasa wykorzystywana do przechowywania danych i zmiany wejscia z jsona, wyjścia na json
 */

public class DataContener {
    /**
     * Pole zawierające tekst do zmiany
     */
    private String text;
    /**
     * Pole zawierające transformacje do wykonania
     */
    private String[] transforms;
    /**
     * Pole zawierające wartość otrzymaną w wyniku transformacji
     */
    private String return_val;
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String[] getTransforms() {
        return transforms;
    }

    public void setTransforms(String[] transforms) {
        this.transforms = transforms;
    }

    public void setReturn_val(String return_val) {
        this.return_val = return_val;
    }

    public String getReturn_val() {
        return return_val;
    }
}
