import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
public final class Length {

    private static final List<Pair> PAIRS = new ArrayList<>();

    private final double value;

    private final Unit unit;

    static {
        PAIRS.add(Pair.create(Unit.FOOT, Unit.FOOT, 1d));
        PAIRS.add(Pair.create(Unit.FOOT, Unit.YARD, 1/3d));
        PAIRS.add(Pair.create(Unit.FOOT, Unit.INCH, 12d));

        PAIRS.add(Pair.create(Unit.YARD, Unit.YARD, 1d));
        PAIRS.add(Pair.create(Unit.YARD, Unit.INCH, 36d));
        PAIRS.add(Pair.create(Unit.YARD, Unit.FOOT, 3d));
    }

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit targetUnit) {
        if (this.unit == Unit.FOOT) {
            return new Length(this.value * radio(this.unit, targetUnit), targetUnit);
        }

        if (this.unit == Unit.YARD) {
            return new Length(this.value * radio(this.unit, targetUnit), targetUnit);
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

    private Double radio(Unit source, Unit target) {
        return PAIRS.stream().filter(pair -> pair.equalsSourceAndTarget(source, target)).findAny().get().getRadio();
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
