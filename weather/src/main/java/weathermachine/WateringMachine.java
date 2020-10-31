package weathermachine;

import java.util.function.Predicate;

public class WateringMachine implements WeatherObserver {

    private boolean status;

    private Predicate<ChangeEvent> predicate;

    public WateringMachine() {
        predicate = changeEvent -> {
            final int temp2Value = 10;
            return changeEvent.getTemp() > temp2Value;
        };

        predicate = predicate.and(changeEvent -> {
            final int humidity2Value = 55;
            return changeEvent.getHumidity() < humidity2Value;
        });

        predicate = predicate.and(changeEvent -> {
            final int windPowerValue = 4;
            return changeEvent.getWindPower() < windPowerValue;
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

