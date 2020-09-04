package radioalarm_states;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class RadioImpl implements Radio {

    private int currentVolume;

    @Override
    public void volumeUp(int delta) {
        currentVolume = Math.min(currentVolume + delta, MAX_VOLUME);
    }

    @Override
    public void volumeDown(int delta) {
        currentVolume = Math.max(currentVolume - delta, MIN_VOLUME);
    }
}
