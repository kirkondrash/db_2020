package radioalarm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class RadioAlarm implements Radio, Alarm {

    private int currentVolume;
    private int alarmHour;
    private int alarmMinute;

    @Override
    public void setTime(int hours, int minutes) {
        alarmHour = hours;
        alarmMinute = minutes;
    }

    @Override
    public void stopSignal() {
        System.out.println("Signal stopped");
    }

    @Override
    public void volumeUp(int delta) {
        currentVolume = Math.min(currentVolume + delta, MAX_VOLUME);
    }

    @Override
    public void volumeDown(int delta) {
        currentVolume = Math.max(currentVolume - delta, MIN_VOLUME);
    }

    public static void main(String[] args) {
        RadioAlarm radioAlarm = RadioAlarm.builder().alarmHour(4).alarmMinute(20).currentVolume(50).build();
        System.out.println(radioAlarm);
        radioAlarm.stopSignal();
        radioAlarm.setTime(6,55);
        radioAlarm.volumeDown(100);
        System.out.println(radioAlarm);
    }
}
