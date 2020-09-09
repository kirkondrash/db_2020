package my_spring;

import heroes.RandomUtil;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
@Component
public class InjectRandomIntAnnotationObjectConfigurer implements ObjectConfigurer {
    @Override
    @SneakyThrows
    public void configure(Object t, ApplicationContext context) {
        Class<?> implClass = t.getClass();
        var fields = ReflectionUtils.getAllFields(implClass);
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int randomInt = RandomUtil.getIntBetween(annotation.min(), annotation.max());
                field.setAccessible(true);
                field.setInt(t, randomInt);
            }
        }
    }
}
