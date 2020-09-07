package my_spring;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {


    @InjectRandomInt(min=1,max=4)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(String.format("Hash: %s, msg: %s", this.hashCode(), "Уборка"));
        }
    }
}
