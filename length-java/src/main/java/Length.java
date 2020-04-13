public class Length {

    private final double value;

    private final Unit unit;

    private Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length createFoot(double value) {
        return new Length(value, Unit.FOOT);
    }

    public static Length createYard(double value) {
        return new Length(value, Unit.YARD);
    }

    public static Length createInch(double value) {
        return new Length(value, Unit.INCH);
    }

    public Length as(Unit target) {
        return new Length(getValue() * RatioConverter.ratio(getUnit(), target), target);
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
