package my_spring;

/**
 * @author Evgeny Borisov
 */
@TargetImpl
@Singleton
public class StubSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(this.hashCode()+"STUB "+message);
    }
}
