package my_spring;

import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * @author Evgeny Borisov
 */
//@TargetImpl
@Singleton
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(String.format("Hash: %s, msg: %s", this.hashCode(), message));
    }
}
