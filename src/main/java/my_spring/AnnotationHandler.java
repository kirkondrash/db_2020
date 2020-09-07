package my_spring;

import java.lang.reflect.Field;

public interface AnnotationHandler {

    void handle(Field f, Object instance);
}
