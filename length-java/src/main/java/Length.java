/**
 * @author sunjing
 */
public class Length {
    private final double value;
    private final String unit;

    private static final String FOOT = "f";

    private static final String YARD = "yard";

    private static final String INCH = "inch";

    public Length(double val, String unit) {
        this.value = val;
        this.unit = unit;
    }

    public Length as(String u) {
        Length len = this;
        if (this.unit.equals(FOOT)) {
            if (u.equals(YARD)) {
                len = new Length(this.value / 3, u);
            } else if (u.equals(INCH)) {
                len = new Length(this.value * 12, u);
            }
        }

        if (this.unit.equals(YARD)) {
            if (u.equals(INCH)) {
                len = new Length(this.value * 36, u);
            } else if (u.equals(FOOT)) {
                len = new Length(this.value * 3, u);
            }
        }

        if (this.unit.equals(INCH)) {
            if (u.equals(FOOT)) {
                len = new Length(this.value / 12, u);
            } else if (u.equals(YARD)) {
                len = new Length(this.value / 36, u);
            }
        }

        return len;
    }

    public double getVal() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
