/**
 * @author sunjing
 */
public class Length {

    public static final String FOOT = "foot";

    public static final String YARD = "yard";

    public static final String INCH = "inch";

    private final double value;

    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String targetUnit) {
        Unit temp_targetUnit;
        if (targetUnit.equals(Length.FOOT)) {
            temp_targetUnit = Unit.FOOT;
        } else if (targetUnit.equals(Length.YARD)) {
            temp_targetUnit = Unit.YARD;
        } else {
            temp_targetUnit = Unit.INCH;
        }

        if (this.unit == Unit.FOOT) {
            return footAs(targetUnit, temp_targetUnit);
        }

        if (this.unit == Unit.YARD) {
            return yardAs(targetUnit);
        }

        if (this.unit == Unit.INCH) {
            return inchAs(targetUnit);
        }

        return this;
    }

    private Length inchAs(String targetUnit) {
        if (targetUnit.equals(FOOT)) {
            return new Length(this.value / 12, Unit.FOOT);
        }

        if (targetUnit.equals(YARD)) {
            return new Length(this.value / 36, Unit.YARD);
        }

        return this;
    }

    private Length yardAs(String targetUnit) {
        if (targetUnit.equals(INCH)) {
            return new Length(this.value * 36, Unit.INCH);
        }

        if (targetUnit.equals(FOOT)){
            return new Length(this.value * 3, Unit.FOOT);
        }

        return this;
    }

    private Length footAs(String targetUnit, Unit temp_targetUnit) {
        if (targetUnit.equals(YARD)) {
            return new Length(this.value / 3, Unit.YARD);
        }

        if (targetUnit.equals(INCH)) {
            return new Length(this.value * 12, Unit.INCH);
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
