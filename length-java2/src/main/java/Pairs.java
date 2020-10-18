import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjing
 */
final class Pairs {

    private static final List<Pair> PAIRS = new ArrayList<>();

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

    static Double radio(Unit source, Unit target) {
        return PAIRS.stream().filter(pair -> pair.equalsSourceAndTarget(source, target)).findAny().get().getRadio();
    }
}
