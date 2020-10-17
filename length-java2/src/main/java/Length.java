/**
 * @author sunjing
 */
public class Length {

    public static final String FOOT = "foot";

    public static final String YARD = "yard";

    public static final String INCH = "inch";

    private final double value;

    private final String unit;

    private Unit temp_unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length(double value, Unit temp_unit) {
        this.value = value;
        this.temp_unit = temp_unit;
        if (temp_unit == Unit.FOOT) {
            this.unit = FOOT;
        } else {
            this.unit = null;
        }
    }

    public Length as(String targetUnit) {
        if (this.unit.equals(FOOT)) {
            return footAs(targetUnit);
        }

        if (this.unit.equals(YARD)) {
            return yardAs(targetUnit);
        }

        if (this.unit.equals(INCH)) {
            return inchAs(targetUnit);
        }

        return this;
    }

    private Length inchAs(String targetUnit) {
        if (targetUnit.equals(FOOT)) {
           return new Length(this.value / 12, targetUnit);
        }

        if (targetUnit.equals(YARD)) {
           return new Length(this.value / 36, targetUnit);
        }

        return this;
    }

    private Length yardAs(String targetUnit) {
        if (targetUnit.equals(INCH)) {
            return new Length(this.value * 36, targetUnit);
        }

        if (targetUnit.equals(FOOT)){
            return new Length(this.value * 3, targetUnit);
        }

        return this;
    }

    private Length footAs(String targetUnit) {
        if (targetUnit.equals(YARD)) {
            return new Length(this.value / 3, targetUnit);
        }

        if (targetUnit.equals(INCH)) {
            return new Length(this.value * 12, targetUnit);
        }


        return this;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
