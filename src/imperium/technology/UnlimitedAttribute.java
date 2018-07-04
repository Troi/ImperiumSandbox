package imperium.technology;

public class UnlimitedAttribute implements Attribute {
    private double limitedValue;

    public UnlimitedAttribute(double limitedValue) {
        this.limitedValue = limitedValue;
    }

    public double getLimitedValue() {
        return limitedValue;
    }
}
