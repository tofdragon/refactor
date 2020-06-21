/**
 * 转换器
 *
 * @author sunjing
 */
public class Converter {

    public static double to(Unit from, Unit to, double value) {
        if (to == Unit.YARD) {
            return value / 3;
        }

        if (to == Unit.INCH) {
            return value * 12;
        }

        if (from == to) {
            return value;
        }

        return 0d;
    }
}
