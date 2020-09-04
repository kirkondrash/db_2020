package homework.class_loading.http_class_handler_creators;

import homework.class_loading.HttpClassHandler;

public interface HttpClassHandlerCreator {

    HttpClassHandler createHandler();

    boolean includesCode(String code);
}
