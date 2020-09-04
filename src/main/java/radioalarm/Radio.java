package radioalarm;

public interface Radio {
    int MIN_VOLUME = 0;
    int MAX_VOLUME = 100;

    void volumeUp(int delta);

    void volumeDown(int delta);
}
