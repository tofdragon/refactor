/**
 * @author sunjing
 */
public class Length {

    private final double value;

    private final String unit;

    /**
     * 英尺
     */
    private static final String FOOT = "f";

    /**
     * 码
     */
    private static final String YARD = "yard";

    /**
     * 英寸
     */
    private static final String INCH = "inch";

    public Length(double val, String unit) {
        this.value = val;
        this.unit = unit;
    }

    public Length as(String to) {
        Length len = this;
        if (this.unit.equals(FOOT)) {
            if (to.equals(YARD)) {
                len = new Length(this.value / 3, to);
            } else if (to.equals(INCH)) {
                len = new Length(this.value * 12, to);
            }
        }

        if (this.unit.equals(YARD)) {
            if (to.equals(INCH)) {
                len = new Length(this.value * 36, to);
            } else if (to.equals(FOOT)) {
                len = new Length(this.value * 3, to);
            }
        }

        if (this.unit.equals(INCH)) {
            if (to.equals(FOOT)) {
                len = new Length(this.value / 12, to);
            } else if (to.equals(YARD)) {
                len = new Length(this.value / 36, to);
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
