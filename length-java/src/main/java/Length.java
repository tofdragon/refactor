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

    public Length as(Unit to) {
        if (this.tempUnit == Unit.FOOT) {
            return footTo(to);
        }

        if (this.tempUnit == Unit.YARD) {
            return yardTo(to);
        }

        if (this.tempUnit == Unit.INCH) {
            return inchTo(to);
        }

        return this;
    }

    private Length footTo(Unit to) {
        if (to == Unit.YARD) {
            return new Length(this.value / 3, YARD);
        }

        if (to == Unit.INCH) {
            return new Length(this.value * 12, INCH);
        }

        return this;
    }

    private Length yardTo(Unit to) {
        if (to == Unit.INCH) {
            return new Length(this.value * 36, INCH);
        }

        if (to == Unit.FOOT) {
            return new Length(this.value * 3, FOOT);
        }

        return this;
    }

    private Length inchTo(Unit to) {
        if (to == Unit.FOOT) {
            return new Length(this.value / 12, FOOT);
        }

        if (to == Unit.YARD) {
            return new Length(this.value / 36, YARD);
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
