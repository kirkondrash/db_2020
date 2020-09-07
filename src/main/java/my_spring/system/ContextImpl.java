package my_spring.system;

import my_spring.system.configuration.Config;
import my_spring.system.object_resolvers.ObjectResolver;
import my_spring.system.object_resolvers.impl.DynamicObjectResolver;

public class ContextImpl implements Context {

    private ObjectFactory objectFactory;
    private SingletonContainer singletonContainer;

    public ContextImpl(Config config){
        ObjectResolver objectResolver = new DynamicObjectResolver(config);
        objectFactory = ObjectFactory.getInstance(objectResolver);
        singletonContainer = SingletonContainer.getInstance(objectFactory);
    }

    public <T> T getObject(Class<T> type) {
        if (singletonContainer.isTypeSingleton(type)){
            return singletonContainer.returnSingleton(type);
        } else {
            return objectFactory.createObject(type);
        }
    }
}
