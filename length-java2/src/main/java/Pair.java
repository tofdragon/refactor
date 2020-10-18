import unit.Unit;

/**
 * @author sunjing
 */
final class Pair {

    private Unit source;

    private Unit target;

    private Double radio;

    private Pair() {
    }

    static Pair create(Unit source, Unit target, double radio) {
        Pair pair = new Pair();
        pair.source = source;
        pair.target = target;
        pair.radio = radio;
        return pair;
    }

    boolean equalsSourceAndTarget(Unit source, Unit target) {
        return this.source == source && this.target == target;
    }

    Double getRadio() {
        return this.radio;
    }
}
