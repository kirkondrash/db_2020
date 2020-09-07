package my_spring.system.object_resolvers;

import java.util.Set;

public interface ObjectResolver {

    <T> Set<Class<? extends T>> getSubTypesOf(Class<T> type);

    public  <T> Class<? extends T> resolveImpl(Class<T> type);
}
