final class Ratio {

    private Unit source;

    private Unit target;

    private Double ratio;

    Ratio(Unit source, Unit target, Double ratio) {
        this.source = source;
        this.target = target;
        this.ratio = ratio;
    }

    Unit getSource() {
        return source;
    }

    Unit getTarget() {
        return target;
    }

    Double getRatio() {
        return ratio;
    }
}
