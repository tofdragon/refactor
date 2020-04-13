import java.util.ArrayList;
import java.util.List;

final class RatioConverter {

    private static List<Ratio> RATIOS = new ArrayList<>();

    static {
        RATIOS.add(new Ratio(Unit.FOOT, Unit.YARD, 1 / 3d));
        RATIOS.add(new Ratio(Unit.FOOT, Unit.INCH, 12d));

        RATIOS.add(new Ratio(Unit.YARD, Unit.INCH, 36d));
        RATIOS.add(new Ratio(Unit.YARD, Unit.FOOT, 3d));

        RATIOS.add(new Ratio(Unit.INCH, Unit.FOOT, 1 / 12d));
        RATIOS.add(new Ratio(Unit.INCH, Unit.YARD, 1 / 36d));
    }

    static Double ratio(final Unit source, final Unit target) {
        Ratio foundRatio = RATIOS.stream()
                .filter(ratio -> ratio.getSource() == source && ratio.getTarget() == target)
                .findAny()
                .orElse(null);
        return foundRatio == null ? 1d : foundRatio.getRatio();
    }
}
