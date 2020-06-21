import java.util.ArrayList;
import java.util.List;

/**
 * 转换器
 *
 * @author sunjing
 */
public class Converter {

    private static List<Pair> pairs = new ArrayList<>();

    static {
        pairs.add(Pair.create(Unit.FOOT, Unit.YARD, 1/3d));
        pairs.add(Pair.create(Unit.FOOT, Unit.INCH, 12d));
        pairs.add(Pair.create(Unit.FOOT, Unit.FOOT, 1d));
    }

    public static double to(Unit from, Unit to, double value) {
        Pair pair = findBy(from, to);
        return value * pair.getRadio();
    }

    private static Pair findBy(Unit from, Unit to) {
        for (Pair pair : pairs) {
            if (pair.equalsFormAndTo(from, to)) {
                return pair;
            }
        }
        return null;
    }
}
