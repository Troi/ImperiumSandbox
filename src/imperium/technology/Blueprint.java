package imperium.technology;

import imperium.politics.Property;

public class Blueprint implements Property {
    private final String name;
    private final Technology originTechnology;

    public Blueprint(String name, Technology originTechnology) {
        this.name = name;
        this.originTechnology = originTechnology;
    }
}
