/**
 * @author sunjing
 */
public class Length {

    private final double value;

    private final Unit tempUnit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.tempUnit = unit;
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
            return new Length(this.value / 3, to);
        }

        if (to == Unit.INCH) {
            return new Length(this.value * 12, to);
        }

        return this;
    }

    private Length yardTo(Unit to) {
        if (to == Unit.INCH) {
            return new Length(this.value * 36, to);
        }

        if (to == Unit.FOOT) {
            return new Length(this.value * 3, to);
        }

        return this;
    }

    private Length inchTo(Unit to) {
        if (to == Unit.FOOT) {
            return new Length(this.value / 12, to);
        }

        if (to == Unit.YARD) {
            return new Length(this.value / 36, to);
        }

        return this;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.tempUnit;
    }
}
