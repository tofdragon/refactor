/**
 * @author sunjing
 */
public class Length {

    public static final String FOOT = "foot";

    public static final String YARD = "yard";

    public static final String INCH = "inch";

    private final double value;

    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Length len = this;

        if (this.unit.equals(FOOT)) {
            return footAs(targetUnit);
        }

        if (this.unit.equals(YARD)) {
            return yardAs(targetUnit);
        }

        if (this.unit.equals(INCH)) {
            return inchAs(targetUnit);
        }

        return len;
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
