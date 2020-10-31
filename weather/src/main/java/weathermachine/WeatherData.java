package weathermachine;

import java.util.ArrayList;
import java.util.List;

public class WeatherData {

    private final List<WeatherObserver> observers = new ArrayList<>();

    public WeatherData(WeatherObserver seedingMachine, WeatherObserver reapingMachine, WeatherObserver wateringMachine) {
        this.observers.add(seedingMachine);
        this.observers.add(reapingMachine);
        this.observers.add(wateringMachine);
    }

    public void measurementsChanged(int temp, int humidity, int windPower) {
        this.observers.forEach(weatherObserver -> {
            weatherObserver.observer(new ChangeEvent(temp, humidity, windPower));
        });
    }
}

