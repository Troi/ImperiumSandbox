package imperium.technology.energy;

import imperium.technology.Attribute;
import imperium.technology.RangeAttribute;
import imperium.technology.TechnologyClass;
import imperium.technology.UnlimitedAttribute;

public class Storage extends TechnologyClass {


    public Storage(String name, Attribute... availableAttributes) {
        super(name, availableAttributes);
    }

    public static class Density extends UnlimitedAttribute implements StorageAttributeInterface {

        public Density(double limitedValue) {
            super(limitedValue);
        }
    }

    public static class MaximumFlow extends UnlimitedAttribute implements StorageAttributeInterface {

        public MaximumFlow(double limitedValue) {
            super(limitedValue);
        }
    }

    public static class MinimalSize extends RangeAttribute implements StorageAttributeInterface {

        public MinimalSize(double bottomLimit, double upperLimit) {
            super(bottomLimit, upperLimit);
        }
    }

    public static class MaximumSize extends RangeAttribute implements StorageAttributeInterface {

        public MaximumSize(double bottomLimit, double upperLimit) {
            super(bottomLimit, upperLimit);
        }
    }
}
