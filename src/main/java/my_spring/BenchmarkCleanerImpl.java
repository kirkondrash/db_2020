package my_spring;

public class BenchmarkCleanerImpl implements Cleaner {

    @InjectByType
    CleanerImpl cleaner;

    @Override
    public void clean() {
        long startTime = System.nanoTime();
        cleaner.clean();
        long stopTime = System.nanoTime();
        System.out.println(String.format("Cleaned for %s", stopTime - startTime));
    }
}
