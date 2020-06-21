/**
 * @author sunjing
 */
public class Length {

    private final double value;

    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit to) {
        if (this.unit == Unit.FOOT) {
            return new Length(Converter.to(this.unit, to, this.value), to);
        }

        if (this.unit == Unit.YARD) {
            return yardTo(to);
        }

        if (this.unit == Unit.INCH) {
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
        return this.unit;
    }
}
