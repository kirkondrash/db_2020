package my_spring;

public interface ObjectFactory {

    Object createObject(Class type);

    boolean isSingleton(Class type);
}
