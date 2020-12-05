/**
 * @author sunjing
 */
public class Length {

    public static final String FOOT = "f";

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
            len = footAs(targetUnit, len);
        }

        if (this.unit.equals(YARD)) {
            len = yardAs(targetUnit, len);
        }

        if (this.unit.equals(INCH)) {
            len = inchAs(targetUnit, len);
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

    private Length footAs(String targetUnit, Length len) {
        if (targetUnit.equals(YARD)) {
            len = new Length(this.value / 3, targetUnit);
        } else if (targetUnit.equals(INCH)) {
            len = new Length(this.value * 12, targetUnit);
        }
        return len;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
