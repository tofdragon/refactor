/**
 * @author sunjing
 */
public class Length {
    
    private final double value;

    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length temp_as(Unit temp_targetUnit) {
        if (this.unit == Unit.FOOT) {
            return footAs(temp_targetUnit);
        }

        if (this.unit == Unit.YARD) {
            return yardAs(temp_targetUnit);
        }

        if (this.unit == Unit.INCH) {
            return inchAs(temp_targetUnit);
        }

        return this;
    }

    private Length inchAs(Unit temp_targetUnit) {
        if (temp_targetUnit == Unit.FOOT) {
           return new Length(this.value / 12, temp_targetUnit);
        }

        if (temp_targetUnit == Unit.YARD) {
           return new Length(this.value / 36, temp_targetUnit);
        }

        return this;
    }

    private Length yardAs(Unit temp_targetUnit) {
        if (temp_targetUnit == Unit.INCH) {
            return new Length(this.value * 36, temp_targetUnit);
        }

        if (temp_targetUnit == Unit.FOOT){
            return new Length(this.value * 3, temp_targetUnit);
        }

        return this;
    }

    private Length footAs(Unit temp_targetUnit) {
        if (temp_targetUnit == Unit.YARD) {
            return new Length(this.value / 3, temp_targetUnit);
        }

        if (temp_targetUnit == Unit.INCH) {
            return new Length(this.value * 12, temp_targetUnit);
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
