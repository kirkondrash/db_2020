package my_spring;

import heroes.RandomUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectRandomIntHandler implements AnnotationHandler {

    @SneakyThrows
    @Override
    public void handle(Field f, Object instance){
        InjectRandomInt repeat = f.getAnnotation(InjectRandomInt.class);
        f.setAccessible(true);
        f.setInt(instance, RandomUtil.getIntBetween(repeat.min(),repeat.max()));
    }
}
