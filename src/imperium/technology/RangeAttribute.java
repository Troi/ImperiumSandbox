package imperium.technology;

public class RangeAttribute implements Attribute {
    private double bottomLimit;
    private double upperLimit;

    public RangeAttribute(double bottomLimit, double upperLimit) {
        this.bottomLimit = bottomLimit;
        this.upperLimit = upperLimit;
    }

    public double getBottomLimit() {
        return bottomLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }
}
