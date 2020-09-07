package my_spring;

import heroes.RandomUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactoryImpl implements ObjectFactory{


    private ObjectFactoryConfig objectFactoryConfig;
    private static ObjectFactory objectFactory = new ObjectFactoryImpl(new ObjectFactoryConfigImpl());

    private ObjectFactoryImpl(ObjectFactoryConfig objectFactoryConfig) {
        this.objectFactoryConfig = objectFactoryConfig;
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public Object createObject(Class type) {
        Class instantiatableClass = objectFactoryConfig.getInstantiatableClass(type);
        Object instance = instantiatableClass.getConstructor().newInstance();

        for (Field f: instantiatableClass.getDeclaredFields()) {
            List<AnnotationHandler> handlers = objectFactoryConfig.getFieldHandlers(f);
            handlers.forEach( annotationHandler -> annotationHandler.handle(f, instance));
        }

        return instance;
    }

    @Override
    public boolean isSingleton(Class type) {
        return objectFactoryConfig.getInstantiatableClass(type).isAnnotationPresent(Singleton.class);
    }
}
