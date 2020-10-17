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
            if (targetUnit.equals(YARD)) {
                len = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(INCH)) {
                len = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(YARD)) {
            if (targetUnit.equals(INCH)) {
                len = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(FOOT)){
                len = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(INCH)) {
            if (targetUnit.equals(FOOT)) {
                len = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals(YARD)) {
                len = new Length(this.value / 36, targetUnit);
            }
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
