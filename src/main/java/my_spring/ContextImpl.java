package my_spring;

import java.util.HashMap;
import java.util.Map;

public class ContextImpl implements Context {

    private ObjectFactory objectFactory;
    private Map<Class, Object> singletons;
    private static Context context = new ContextImpl(ObjectFactoryImpl.getInstance());

    private ContextImpl(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
        this.singletons = new HashMap<>();
    }

    public static Context getInstance() {
        return context;
    }

    public <U extends T,T> U getObject(Class<T> type) {
        if (objectFactory.isSingleton(type)){
            return (U) singletons.computeIfAbsent(type, (t) -> objectFactory.createObject(t));
        } else {
            return objectFactory.createObject(type);
        }
    }
}
