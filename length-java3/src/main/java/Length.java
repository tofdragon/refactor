/**
 * @author sunjing
 */
public class Length {

    public static final String FOOT = "foot";

    public static final String YARD = "yard";

    public static final String INCH = "inch";

    private final double value;

    private final String unit;

    private Unit temp_unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
        if (this.unit.equals(Length.FOOT)) {
            this.temp_unit = Unit.FOOT;
        } else if (this.unit.equals(Length.YARD)) {
            this.temp_unit = Unit.YARD;
        } else {
            this.temp_unit = Unit.INCH;
        }
    }

    public Length(double value, Unit unit) {
        this.value = value;
        this.temp_unit = unit;
        if (this.temp_unit == Unit.FOOT) {
            this.unit = Length.FOOT;
        } else if (this.temp_unit == Unit.YARD) {
            this.unit = Length.YARD;
        } else {
            this.unit = Length.INCH;
        }
    }

    public Length as(String targetUnit) {
        if (this.unit.equals(FOOT)) {
            return footAs(targetUnit);
        }

        if (this.unit.equals(YARD)) {
            return yardAs(targetUnit);
        }

        if (this.unit.equals(INCH)) {
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
        return this.temp_unit;
    }
}
