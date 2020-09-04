package radioalarm_states;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class RadioAlarm implements Radio, Alarm {

    private Alarm alarm;
    private Radio radio;

    @Override
    public void setTime(int hours, int minutes) {
        alarm.setTime(hours,minutes);
    }

    @Override
    public void stopSignal() {
        alarm.stopSignal();
    }

    @Override
    public void volumeUp(int delta) {
        radio.volumeUp(delta);
    }

    @Override
    public void volumeDown(int delta) {
        radio.volumeDown(delta);
    }

    public static void main(String[] args) {
        RadioAlarm radioAlarm = new RadioAlarm(new AlarmImpl(4,20), new RadioImpl(50));
        System.out.println(radioAlarm);
        radioAlarm.stopSignal();
        radioAlarm.setTime(6,55);
        radioAlarm.volumeDown(100);
        System.out.println(radioAlarm);
    }
}
