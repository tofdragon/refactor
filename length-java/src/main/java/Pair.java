/**
 *
 * @author sunjing
 */
public class Pair {

    private Unit from;

    private Unit to;

    private Double radio;

    private Pair() {
    }

    public static Pair create(Unit from, Unit to, Double radio) {
        Pair pair = new Pair();
        pair.from = from;
        pair.to = to;
        pair.radio = radio;
        return pair;
    }

    public boolean equalsFormAndTo(Unit from, Unit to) {
        return this.from == from && this.to == to;
    }

    public Double getRadio() {
        return radio;
    }
}
