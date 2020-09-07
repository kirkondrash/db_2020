package my_spring.system.object_resolvers.impl;

import my_spring.system.configuration.Config;
import my_spring.system.object_resolvers.ObjectResolver;
import org.reflections.Reflections;

import java.util.Set;

public class DynamicObjectResolver implements ObjectResolver {

    private Config config;

    private Reflections scanner;

    public DynamicObjectResolver(Config config) {
        this.config = config;
        this.scanner = new Reflections(config.getPackageToScan());
    }

    public <T> Set<Class<? extends T>> getSubTypesOf(Class<T> type) {
        return scanner.getSubTypesOf(type);
    }

    public  <T> Class<? extends T> resolveImpl(Class<T> type) {
        Class<? extends T> implClass;
        if (type.isInterface()) {
            implClass = config.getImpl(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl, please update your config");
                }
                implClass = classes.iterator().next();
            }
        }else {
            implClass = type;
        }
        return implClass;
    }
}
