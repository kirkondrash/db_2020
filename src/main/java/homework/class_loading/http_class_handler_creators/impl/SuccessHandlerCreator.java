package homework.class_loading.http_class_handler_creators.impl;


import homework.class_loading.http_class_handler_creators.AbstractHttpClassHandlerCreator;
import homework.class_loading.HttpClassHandler;

public class SuccessHandlerCreator extends AbstractHttpClassHandlerCreator {

    public SuccessHandlerCreator() {
        super("2");
    }

    private class SuccessHandler implements HttpClassHandler{

        @Override
        public void work() {
            System.out.println("Success! ^_^");
        }
    }

    @Override
    public HttpClassHandler createHandler() {
        return new SuccessHandler();
    }
}
