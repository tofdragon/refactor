import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void should_1_inch_equals_1_inch() {
        Length result = Length.createInch(1).as(Unit.INCH);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getUnit(), is(Unit.INCH));
    }

    @Test
    public void should_2_feet_equals_2_feet() {
        Length result = Length.createFoot(2).as(Unit.FOOT);

        assertThat(result.getValue(), is(2.0));
        assertThat(result.getUnit(), is(Unit.FOOT));
    }

    @Test
    public void should_1_yard_equals_1_yard() {
        Length result = Length.createYard(1).as(Unit.YARD);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getUnit(), is(Unit.YARD));
    }

    @Test
    public void should_1_foot_equals_12_inches() {
        Length result = Length.createFoot(1).as(Unit.INCH);

        assertThat(result.getValue(), is(12.0));
        assertThat(result.getUnit(), is(Unit.INCH));
    }

    @Test
    public void should_3_foot_equals_1_yard() {
        Length result = Length.createFoot(3).as(Unit.YARD);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getUnit(), is(Unit.YARD));
    }

    @Test
    public void should_1_yard_equals_3_feet() {
        Length result = Length.createYard(1).as(Unit.FOOT);

        assertThat(result.getValue(), is(3.0));
        assertThat(result.getUnit(), is(Unit.FOOT));
    }

    @Test
    public void should_1_yard_equals_36_inches() {
        Length result = Length.createYard(1).as(Unit.INCH);

        assertThat(result.getValue(), is(36.0));
        assertThat(result.getUnit(), is(Unit.INCH));
    }

    @Test
    public void should_2_yards_equals_72_inches() {
        Length result = Length.createYard(2).as(Unit.INCH);

        assertThat(result.getValue(), is(72.0));
        assertThat(result.getUnit(), is(Unit.INCH));
    }

    @Test
    public void should_12_inches_equals_1_foot() {
        Length result = Length.createInch(12).as(Unit.FOOT);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getUnit(), is(Unit.FOOT));
    }

    @Test
    public void should_36_inches_equals_1_yard() {
        Length result = Length.createInch(36).as(Unit.YARD);

        assertThat(result.getValue(), is(1.0));
        assertThat(result.getUnit(), is(Unit.YARD));
    }

    @Test
    public void should_18_inches_equals_half_yard() {
        Length result = Length.createInch(18).as(Unit.YARD);

        assertThat(result.getValue(), is(0.5));
        assertThat(result.getUnit(), is(Unit.YARD));
    }
}
