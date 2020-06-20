/**
 * @author sunjing
 */
public class Length {

    private final double value;

    private final String unit;

    private final Unit tempUnit;

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
        if (unit.equals(FOOT)) {
            this.tempUnit = Unit.FOOT;
        } else if (unit.equals(YARD)) {
            this.tempUnit = Unit.YARD;
        } else {
            this.tempUnit = Unit.INCH;
        }
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

    public Length as(Unit to) {
        if (this.tempUnit == Unit.FOOT) {
            return footTo(FOOT);
        }

        if (this.tempUnit == Unit.YARD) {
            return yardTo(YARD);
        }

        if (this.tempUnit == Unit.INCH) {
            return inchTo(INCH);
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
