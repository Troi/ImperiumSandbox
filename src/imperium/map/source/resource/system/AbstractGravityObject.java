package imperium.map.source.resource.system;

import imperium.map.source.resource.MapResourceInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGravityObject implements MapResourceInterface {
    private List<MapResourceInterface> satelites;

    private long mass = 1;
    private long size = 1;
    private long g = 10;
    private long rotationPeriod = 1;
    private long atmosphereHeight = 1;

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

    public long getMass() {
        return mass;
    }

    public void setMass(long mass) {
        this.mass = mass;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getG() {
        return g;
    }

    public void setG(long g) {
        this.g = g;
    }

    public long getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(long rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public long getAtmosphereHeight() {
        return atmosphereHeight;
    }

    public void setAtmosphereHeight(long atmosphereHeight) {
        this.atmosphereHeight = atmosphereHeight;
    }
}
