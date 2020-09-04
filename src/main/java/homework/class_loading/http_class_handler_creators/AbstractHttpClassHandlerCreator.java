package homework.class_loading.http_class_handler_creators;

import homework.class_loading.HttpClassHandler;

public abstract class AbstractHttpClassHandlerCreator implements HttpClassHandlerCreator {

    private final String firstDigit;

    protected AbstractHttpClassHandlerCreator(String firstDigit) {
        this.firstDigit = firstDigit;
    }

    public abstract HttpClassHandler createHandler();

    public boolean includesCode(String code) {
        return code.startsWith(firstDigit);
    }
}
