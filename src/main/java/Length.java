public class Length {

    public static final String FOOT = "f";

    public static final String YARD = "yard";

    public static final String INCH = "inch";

    private final double value;

    private final String unit;

    private Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Length createFoot(double value) {
        return new Length(value, FOOT);
    }

    public static Length createYard(double value) {
        return new Length(value, YARD);
    }

    public static Length createInch(double value) {
        return new Length(value, INCH);
    }

    public Length as(String target) {
        if (this.unit.equals(FOOT)) {
            return footTo(target);
        }

        if (this.unit.equals(YARD)) {
            return yardTo(target);
        }

        if (this.unit.equals(INCH)) {
            return inchTo(target);
        }

        return this;
    }

    private Length footTo(String target) {
        if (target.equals(YARD)) {
            return Length.createYard(this.value / 3);
        }

        if (target.equals(INCH)) {
            return Length.createInch(this.value * 12);
        }

        return this;
    }

    private Length yardTo(String target) {
        if (target.equals(INCH)) {
            return Length.createInch(this.value * 36);
        }

        if (target.equals(FOOT)) {
            return Length.createFoot(this.value * 3);
        }

        return this;
    }

    private Length inchTo(String target) {
        if (target.equals(FOOT)) {
            return Length.createFoot(this.value / 12);
        }

        if (target.equals(YARD)) {
            return Length.createYard(this.value / 36);
        }

        return this;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
