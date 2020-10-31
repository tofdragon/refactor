package weathermachine;

import java.util.function.Predicate;

public class ReapingMachine implements WeatherObserver {

    private boolean status;

    private Predicate<ChangeEvent> predicate;

    public ReapingMachine() {
        predicate = changeEvent -> {
            final int tempValue = 5;
            return changeEvent.getTemp() > tempValue;
        };

        predicate = predicate.and(changeEvent -> {
            final int humidityValue = 65;
            return changeEvent.getHumidity() > humidityValue;
        });

        predicate = predicate.and(changeEvent -> {
            this.start();
            return true;
        });
    }

    public boolean getStatus() {
        return status;
    }

    public void start() {
        status = true;
    }

    @Override
    public void observer(ChangeEvent changeEvent) {
        predicate.test(changeEvent);
    }
}
