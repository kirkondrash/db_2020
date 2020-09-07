package my_spring;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class ObjectFactoryConfigImpl implements ObjectFactoryConfig {

    private final List<Class> interfaces = List.of(Cleaner.class,Speaker.class);
    private final Map<Class, AnnotationHandler> fieldAnnotationHandlers = Map.of(InjectRandomInt.class, new InjectRandomIntHandler());
    private final Map<Class, Class> ifc2ImplClass = new HashMap<>();

    {
        Reflections scanner = new Reflections("my_spring");
        for (Class ifc: interfaces){
            Set<Class<?>> impls = scanner.getSubTypesOf(ifc);
            if (impls.size() == 1) {
                ifc2ImplClass.put(ifc, (Class) impls.toArray()[0]);
            } else { // works for both 0 and >1 cases
                Class targetImpl = impls
                        .stream()
                        .filter(impl -> impl.isAnnotationPresent(TargetImpl.class))
                        .findFirst()
                        .orElseThrow(() -> new ClassCastException(String.format("Implementation of %s not found or vague!", ifc)));
                ifc2ImplClass.put(ifc, targetImpl);
            }
        }
    }

    @Override
    public Class getInstantiatableClass(Class type) {
        if (Modifier.isAbstract(type.getModifiers()) || Modifier.isInterface(type.getModifiers())){
            return ifc2ImplClass.get(type);
        } else {
            return type;
        }
    }

    @Override
    public List<AnnotationHandler> getFieldHandlers(Field f){
        return Arrays.stream(f.getAnnotations())
                .filter(annotation -> fieldAnnotationHandlers.containsKey(annotation.annotationType()))
                .map(annotation -> fieldAnnotationHandlers.get(annotation.annotationType()))
                .collect(Collectors.toList());
    }
}
