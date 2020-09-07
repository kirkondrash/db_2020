package my_spring.system;

import lombok.Setter;
import my_spring.system.annotations.Singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonContainer {

    @Setter
    private ObjectFactory objectFactory;
    private Map<Class<?>, Object> singletons = new HashMap<>();
    private static SingletonContainer singletonContainer = new SingletonContainer();

    public static SingletonContainer getInstance(ObjectFactory objectFactory) {
        singletonContainer.setObjectFactory(objectFactory);
        return singletonContainer;
    }

    public boolean isTypeSingleton(Class<?> type) {
        Class<?> implClass = objectFactory.getObjectResolver().resolveImpl(type);
        return singletons.containsKey(implClass) || implClass.isAnnotationPresent(Singleton.class);
    }

    public <T> T returnSingleton(Class<T> type){
        return (T) singletons.computeIfAbsent(objectFactory.getObjectResolver().resolveImpl(type), t -> objectFactory.createObject(t));
    }
}
