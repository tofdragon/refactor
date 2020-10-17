/**
 * @author sunjing
 */
public final class Length {

    private final double value;

    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit targetUnit) {
        if (this.unit == Unit.FOOT) {
            return footAs(targetUnit);
        }

        if (this.unit == Unit.YARD) {
            return yardAs(targetUnit);
        }

        if (this.unit == Unit.INCH) {
            return inchAs(targetUnit);
        }

        return this;
    }

    private Length inchAs(Unit targetUnit) {
        if (targetUnit == Unit.FOOT) {
            return new Length(this.value / 12, targetUnit);
        }

        if (targetUnit == Unit.YARD) {
            return new Length(this.value / 36, targetUnit);
        }

        return this;
    }

    private Length yardAs(Unit targetUnit) {
        if (targetUnit == Unit.INCH) {
            return new Length(this.value * 36, targetUnit);
        }

        if (targetUnit == Unit.FOOT) {
            return new Length(this.value * 3, targetUnit);
        }

        return this;
    }

    private Length footAs(Unit targetUnit) {
        if (targetUnit == Unit.YARD) {
            return new Length(this.value / 3, targetUnit);
        }

        if (targetUnit == Unit.INCH) {
            return new Length(this.value * 12, targetUnit);
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
