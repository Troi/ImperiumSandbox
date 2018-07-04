package imperium.technology.energy;

import imperium.technology.*;

import java.util.HashSet;
import java.util.Set;

public class Source extends TechnologyClass {

    public static Set<Source> sources;

    private Stability stability;
    private MaximumFlow maximumFlow;
    private MinimalSize minimalSize;
    private MaximumSize maximumSize;

    static {
        sources = new HashSet<>();
        sources.add(new Source("Elektrokolo", new Stability(), new MaximumFlow(1), new MinimalSize(1000, 2000), new MaximumSize(2000, 2000)));
        sources.add(new Source("Jaderna elektrarna", new Stability(), new MaximumFlow(1000000), new MinimalSize(1000000, 2000000), new MaximumSize(2000000, 9000000)));
    }

    public Source(String name, Stability stability, MaximumFlow maximumFlow, MinimalSize minimalSize, MaximumSize maximumSize) {
        super(name, stability, maximumFlow, minimalSize, maximumSize);
        this.stability = stability;
        this.maximumFlow = maximumFlow;
        this.minimalSize = minimalSize;
        this.maximumSize = maximumSize;
    }

    public static class Stability extends EnumAttribute implements SourceAttributeInterface {
    }

    private enum TYPES {
        CONSTANT, LINEAR, EXPONENCIAL
    }

    public static class Density extends UnlimitedAttribute implements SourceAttributeInterface {

        public Density(double limitedValue) {
            super(limitedValue);
        }
    }

    public static class MaximumFlow extends UnlimitedAttribute implements SourceAttributeInterface {

        public MaximumFlow(double limitedValue) {
            super(limitedValue);
        }
    }

    public static class MinimalSize extends RangeAttribute implements SourceAttributeInterface {

        public MinimalSize(double bottomLimit, double upperLimit) {
            super(bottomLimit, upperLimit);
        }
    }

    public static class MaximumSize extends RangeAttribute implements SourceAttributeInterface {

        public MaximumSize(double bottomLimit, double upperLimit) {
            super(bottomLimit, upperLimit);
        }
    }

}
