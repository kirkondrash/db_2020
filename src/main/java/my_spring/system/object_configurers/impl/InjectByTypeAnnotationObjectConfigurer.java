package my_spring.system.object_configurers.impl;

import lombok.SneakyThrows;
import my_spring.system.annotations.InjectByType;
import my_spring.system.ObjectFactory;
import my_spring.system.object_configurers.ObjectConfigurer;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectByTypeAnnotationObjectConfigurer implements ObjectConfigurer {
    @SneakyThrows
    @Override
    public void configure(Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object value = ObjectFactory.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }
}
