package imperium.technology;

import java.util.List;
import java.util.Map;

public class Technology {
    private final TechnologyClass technologyClass;
    private final Map<Attribute, Integer> attributeValues;

    public Technology(TechnologyClass technologyClass, Map<Attribute, Integer> attributeValues) {
        this.technologyClass = technologyClass;
        this.attributeValues = attributeValues;
    }
}
