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

        PAIRS.add(Pair.create(Unit.INCH, Unit.INCH, 1d));
        PAIRS.add(Pair.create(Unit.INCH, Unit.FOOT, 1/12d));
        PAIRS.add(Pair.create(Unit.INCH, Unit.YARD, 1/36d));
    }

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit targetUnit) {
        return new Length(this.value * radio(this.unit, targetUnit), targetUnit);
    }

    private Double radio(Unit source, Unit target) {
        return Pairs.radio(source, target);
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
