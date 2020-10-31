package weathermachine;

import java.util.function.Predicate;

public class SeedingMachine implements WeatherObserver {

    private boolean status;

    private Predicate<ChangeEvent> predicate;

    public SeedingMachine() {
        predicate = changeEvent -> {
            final int temp2Value = 5;
            return changeEvent.getTemp() > temp2Value;
        };

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
