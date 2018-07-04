package imperium.map.source.resource.system;

import imperium.map.source.resource.MapResourceInterface;

public class AbstractStellarObject implements MapResourceInterface {
    private Orbit orbit;

    public Orbit getOrbit() {
        return orbit;
    }

    public void setOrbit(Orbit orbit) {
        this.orbit = orbit;
    }
}
