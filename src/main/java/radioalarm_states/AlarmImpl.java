package radioalarm_states;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class AlarmImpl implements Alarm {

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
}
