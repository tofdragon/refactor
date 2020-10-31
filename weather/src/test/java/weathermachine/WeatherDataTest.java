package weathermachine;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sunjing
 */
public class WeatherDataTest {

    @Test
    public void shouldSeedingMachineStart() {
        SeedingMachine seedingMachine = new SeedingMachine();
        ReapingMachine reapingMachine = new ReapingMachine();
        WateringMachine wateringMachine = new WateringMachine();

        WeatherData weatherData = new WeatherData(seedingMachine, reapingMachine, wateringMachine);
        weatherData.measurementsChanged(6, 60, 10);

        Assert.assertTrue(seedingMachine.getStatus());
        Assert.assertFalse(reapingMachine.getStatus());
        Assert.assertFalse(wateringMachine.getStatus());
    }

    @Test
    public void shouldSeedingMachineAndReapingMachineStart() {
        SeedingMachine seedingMachine = new SeedingMachine();
        ReapingMachine reapingMachine = new ReapingMachine();
        WateringMachine wateringMachine = new WateringMachine();

        WeatherData weatherData = new WeatherData(seedingMachine, reapingMachine, wateringMachine);
        weatherData.measurementsChanged(6, 70, 10);

        Assert.assertTrue(seedingMachine.getStatus());
        Assert.assertTrue(reapingMachine.getStatus());
        Assert.assertFalse(wateringMachine.getStatus());
    }

    @Test
    public void shouldSeedingMachineAndWateringMachineStart() {
        SeedingMachine seedingMachine = new SeedingMachine();
        ReapingMachine reapingMachine = new ReapingMachine();
        WateringMachine wateringMachine = new WateringMachine();

        WeatherData weatherData = new WeatherData(seedingMachine, reapingMachine, wateringMachine);
        weatherData.measurementsChanged(11, 20, 3);

        Assert.assertTrue(seedingMachine.getStatus());
        Assert.assertFalse(reapingMachine.getStatus());
        Assert.assertTrue(wateringMachine.getStatus());
    }
}

