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
        return new Length(this.value * Pairs.radio(this.unit, targetUnit), targetUnit);
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
