package my_spring.system;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import my_spring.system.object_configurers.ObjectConfigurer;
import my_spring.system.object_resolvers.ObjectResolver;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    @Getter
    @Setter
    private ObjectResolver objectResolver;
    private static ObjectFactory objectFactory = new ObjectFactory();
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();

    @SneakyThrows
    private ObjectFactory() {
        Reflections systemScanner = new Reflections("my_spring.system.object_configurers.impl");
        Set<Class<? extends ObjectConfigurer>> classes = systemScanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    public static ObjectFactory getInstance(ObjectResolver objectResolver) {
        objectFactory.setObjectResolver(objectResolver);
        return objectFactory;
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = objectResolver.resolveImpl(type);
        T t = create(implClass);
        configure(t);
        invokeInitMethod(implClass, t);
        return t;
    }




    private <T> void invokeInitMethod(Class<? extends T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(implClass);
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);

            }
        }
    }



















    private <T> void configure(T t) {
        objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t));
    }

    private <T> T create(Class<? extends T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        return implClass.getDeclaredConstructor().newInstance();
    }
}








