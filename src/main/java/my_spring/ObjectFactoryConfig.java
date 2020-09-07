package my_spring;

import java.lang.reflect.Field;
import java.util.List;

public interface ObjectFactoryConfig {

    Class getInstantiatableClass(Class type);

    List<AnnotationHandler> getFieldHandlers(Field f);
}
