package my_spring;

public interface Context {

    <U extends T,T> U getObject(Class<T> type);
}
