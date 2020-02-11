public class Length {
    private final double value;
    private final String unit;

    public Length(double val, String unit) {
        this.value = val;
        this.unit = unit;
    }

    public Length as(String u) {
        if (this.unit.equals("f")) {
            return footTo(u);
        }

        if (this.unit.equals("yard")) {
            return yardTo(u);
        }

        if (this.unit.equals("inch")) {
            return inchTo(u);
        }

        return this;
    }

    private Length footTo(String target) {
        if (target.equals("yard")) {
            return new Length(this.value / 3, target);
        } else if (target.equals("inch")) {
            return new Length(this.value * 12, target);
        } else {
            return this;
        }
    }

    private Length yardTo(String target) {
        if (target.equals("inch")) {
            return new Length(this.value * 36, target);
        } else if (target.equals("f")) {
            return new Length(this.value * 3, target);
        } else {
            return this;
        }
    }

    private Length inchTo(String target) {
        if (target.equals("f")) {
            return new Length(this.value / 12, target);
        } else if (target.equals("yard")) {
            return new Length(this.value / 36, target);
        } else {
            return this;
        }
    }

    public double getVal() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
