package homework.enums.http_classes;

public abstract class HttpClass implements HttpClassHandler{

    private final String firstDigit;

    protected HttpClass(String firstDigit) {
        this.firstDigit = firstDigit;
    }

    public abstract void work();

    public boolean includesCode(String code) {
        return code.startsWith(firstDigit);
    }
}
