/**
 * @author sunjing
 */
public class Length {

    private static final String F = "f";

    private static final String YARD = "yard";

    private static final String INCH = "inch";

    private final double value;

    private final String unit;


    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Length len = this;

        if (this.unit.equals(F)) {
            if (targetUnit.equals(YARD)) {
                len = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(INCH)) {
                len = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(YARD)) {
            if (targetUnit.equals(INCH)) {
                len = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(F)){
                len = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(INCH)) {
            if (targetUnit.equals(F)) {
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
