package imperium.map.source.resource.system;

import imperium.map.source.resource.MapResourceInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGravityObject implements MapResourceInterface {
    private List<MapResourceInterface> satelites;

    public AbstractGravityObject() {
        this.satelites = new ArrayList<>();
    }

    public AbstractGravityObject(List<MapResourceInterface> satelites) {
        this.satelites = satelites;
    }

    public List<MapResourceInterface> getSatelites() {
        return satelites;
    }

    public void setSatelites(List<MapResourceInterface> satelites) {
        this.satelites = satelites;
    }

    public void addSatelite(MapResourceInterface satelite) {
        this.satelites.add(satelite);
    }
}
