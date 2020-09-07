package my_spring;

import heroes.RandomUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectByTypeAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> implClass = t.getClass();
        Field[] fields = implClass.getDeclaredFields();
        for (Field field : fields) {
            InjectByType annotation = field.getAnnotation(InjectByType.class);
            if (annotation != null) {
                field.setAccessible(true);
                field.set(t, ObjectFactory.getInstance().createObject(field.getType()));
            }
        }
    }
}
