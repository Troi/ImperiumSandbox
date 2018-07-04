package imperium.map.view;

import imperium.map.source.resource.MapResourceInterface;
import imperium.people.Human;

public class PoliticMapResourceDecorator implements MapResourceInterface {
    private final MapResourceInterface property;
    private String name;
    private Human owner;
    private Human manager;

    public PoliticMapResourceDecorator(MapResourceInterface property) {
        this.property = property;
    }

    public MapResourceInterface getProperty() {
        return property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }

    public Human getManager() {
        return manager;
    }

    public void setManager(Human manager) {
        this.manager = manager;
    }

}
