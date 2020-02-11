public class Length {
    private final double value;
    private final String unit;

    public Length(double val, String unit) {
        this.value = val;
        this.unit = unit;
    }

    public Length as(String target) {
        if (this.unit.equals("f")) {
            return footTo(target);
        }

        if (this.unit.equals("yard")) {
            return yardTo(target);
        }

        if (this.unit.equals("inch")) {
            return inchTo(target);
        }

        return this;
    }

    private Length footTo(String target) {
        if (target.equals("yard")) {
            return new Length(this.value / 3, target);
        }

        if (target.equals("inch")) {
            return new Length(this.value * 12, target);
        }

        return this;
    }

    private Length yardTo(String target) {
        if (target.equals("inch")) {
            return new Length(this.value * 36, target);
        }

        if (target.equals("f")) {
            return new Length(this.value * 3, target);
        }

        return this;
    }

    private Length inchTo(String target) {
        if (target.equals("f")) {
            return new Length(this.value / 12, target);
        }

        if (target.equals("yard")) {
            return new Length(this.value / 36, target);
        }

        return this;
    }

    public double getVal() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
