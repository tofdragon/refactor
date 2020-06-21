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
        return new Length(Converter.to(getUnit(), to, getValue()), to);
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
