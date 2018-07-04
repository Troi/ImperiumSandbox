package imperium.technology;

import java.util.ArrayList;
import java.util.List;

public abstract class TechnologyClass {
    private final String name;
    private final Attribute[] availableAttributes;

    public TechnologyClass(String name, Attribute... availableAttributes) {
        this.name = name;
        this.availableAttributes = availableAttributes;
    }

}
