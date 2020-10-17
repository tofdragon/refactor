/**
 * @author sunjing
 */
public class Length {
    private final double value;
    private final String unit;
    private static final String F = "f";

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Length len = this;
        final String yard = "yard";
        final String inch = "inch";

        if (this.unit.equals(F)) {
            if (targetUnit.equals(yard)) {
                len = new Length(this.value / 3, targetUnit);
            } else if (targetUnit.equals(inch)) {
                len = new Length(this.value * 12, targetUnit);
            }
        }

        if (this.unit.equals(yard)) {
            if (targetUnit.equals(inch)) {
                len = new Length(this.value * 36, targetUnit);
            } else if (targetUnit.equals(F)){
                len = new Length(this.value * 3, targetUnit);
            }
        }

        if (this.unit.equals(inch)) {
            if (targetUnit.equals(F)) {
                len = new Length(this.value / 12, targetUnit);
            } else if (targetUnit.equals(yard)) {
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
