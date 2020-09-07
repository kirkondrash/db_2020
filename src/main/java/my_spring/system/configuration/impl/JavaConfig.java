package my_spring.system.configuration.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import my_spring.system.configuration.Config;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Getter
@RequiredArgsConstructor
public class JavaConfig implements Config {

    private final Map<Class<?>, Class<?>> ifc2Implclass;
    private final String packageToScan;

    @Override
    public <T> Class<? extends T> getImpl(Class<T> type) {
        return (Class<? extends T>) ifc2Implclass.get(type);
    }




}
