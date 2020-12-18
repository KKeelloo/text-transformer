package pl.put.poznan.transformer.rest;

/**
 * Klasa wykorzystana do transfomowania wyjscia z TransformationNotFoundAdvice do jsona
 */


public class ErrorInfo {
    /**
     * Pole do widomości z błędu
     */
    private String message;
    /**
     * Pole do adresu url który wywołał błąd
     */
    private String url;

    /**
     * Konstruktor
     * @param message ustawia wartość pola messaga
     * @param url ustawia wartość pola url
     */
    ErrorInfo(String message,String url){
        this.message = message;
        this.url = url;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
