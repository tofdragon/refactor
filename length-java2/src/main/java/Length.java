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
        Unit temp_targetUnit = null;
        if (targetUnit.equals(FOOT)) {
            temp_targetUnit = Unit.FOOT;
        } else if (targetUnit.equals(YARD)) {
            temp_targetUnit = Unit.YARD;
        }

        if (this.unit == Unit.FOOT) {
            return footAs(targetUnit);
        }

        if (this.unit == Unit.YARD) {
            return yardAs(targetUnit);
        }

        if (this.unit == Unit.INCH) {
            return inchAs(temp_targetUnit);
        }

        return this;
    }

    private Length inchAs(Unit temp_targetUnit) {
        if (temp_targetUnit == Unit.FOOT) {
           return new Length(this.value / 12, Unit.FOOT);
        }

        if (temp_targetUnit == Unit.YARD) {
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

    private Length footAs(String targetUnit) {
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
