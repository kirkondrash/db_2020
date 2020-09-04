package homework.class_loading.http_class_handler_creators.impl;

import homework.class_loading.http_class_handler_creators.AbstractHttpClassHandlerCreator;
import homework.class_loading.HttpClassHandler;

public class InformationalHandlerCreator extends AbstractHttpClassHandlerCreator {

    public InformationalHandlerCreator() {
        super("1");
    }

    private class InformationalHandler implements HttpClassHandler{

        @Override
        public void work() {
            System.out.println("Informational. -_-");
        }
    }

    @Override
    public HttpClassHandler createHandler() {
        return new InformationalHandler();
    }
}
