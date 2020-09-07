package my_spring;

/**
 * @author Evgeny Borisov
 */
public class IRobot {

    private Speaker speaker = ContextImpl.getInstance().getObject(Speaker.class);
    private Cleaner cleaner = ContextImpl.getInstance().getObject(Cleaner.class);

    public void cleanRoom() {
        speaker.speak("Я начал уборку");
        cleaner.clean();
        cleaner = ContextImpl.getInstance().getObject(Cleaner.class); // other hash, not singleton
        cleaner.clean();
        speaker = ContextImpl.getInstance().getObject(Speaker.class); // same hash, singleton
        speaker.speak("Я закончил уборку");
    }
}
