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

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String to) {
        if (this.unit.equals(FOOT)) {
            return footTo(to);
        }

        if (this.unit.equals(YARD)) {
            return yardTo(to);
        }

        if (this.unit.equals(INCH)) {
            return inchTo(to);
        }

        return this;
    }

    private Length footTo(String to) {
        if (to.equals(YARD)) {
            return new Length(this.value / 3, to);
        }

        if (to.equals(INCH)) {
            return new Length(this.value * 12, to);
        }

        return this;
    }

    private Length yardTo(String to) {
        if (to.equals(INCH)) {
            return new Length(this.value * 36, to);
        }

        if (to.equals(FOOT)) {
            return new Length(this.value * 3, to);
        }

        return this;
    }

    private Length inchTo(String to) {
        if (to.equals(FOOT)) {
            return new Length(this.value / 12, to);
        }

        if (to.equals(YARD)) {
            return new Length(this.value / 36, to);
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
