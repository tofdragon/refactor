package weathermachine;

/**
 * @author sunjing
 */
public class ChangeEvent {

    private int temp;

    private int humidity;

    private int windPower;

    public ChangeEvent(int temp, int humidity, int windPower) {
        this.temp = temp;
        this.humidity = humidity;
        this.windPower = windPower;
    }

    public int getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getWindPower() {
        return windPower;
    }
}
