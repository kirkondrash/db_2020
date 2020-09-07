package my_spring.system;

public interface Context {

    <T> T getObject(Class<T> type);
}
