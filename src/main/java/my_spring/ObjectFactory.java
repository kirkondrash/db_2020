package my_spring;

public interface ObjectFactory {

    <U extends T, T> U createObject(Class<T> type);

    boolean isSingleton(Class type);
}
