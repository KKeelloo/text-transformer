package pl.put.poznan.transformer.rest;

public class ErrorInfo {
    private String message;
    private String url;

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
