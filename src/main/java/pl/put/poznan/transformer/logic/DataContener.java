package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataContener {
    private String text;
    private String[] transforms;
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
