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
            return yardAs(targetUnit, len);
        }

        if (this.unit.equals(INCH)) {
            return inchAs(targetUnit, len);
        }

        return len;
    }

    private Length inchAs(String targetUnit, Length len) {
        if (targetUnit.equals(FOOT)) {
            len = new Length(this.value / 12, targetUnit);
        } else if (targetUnit.equals(YARD)) {
            len = new Length(this.value / 36, targetUnit);
        }
        return len;
    }

    private Length yardAs(String targetUnit, Length len) {
        if (targetUnit.equals(INCH)) {
            len = new Length(this.value * 36, targetUnit);
        } else if (targetUnit.equals(FOOT)){
            len = new Length(this.value * 3, targetUnit);
        }
        return len;
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
