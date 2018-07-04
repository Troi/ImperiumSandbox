package imperium.map.source;

import imperium.map.source.resource.MapResourceInterface;
import imperium.map.source.resource.system.AsteroidBelt;
import imperium.map.source.resource.system.Planet;
import imperium.map.source.resource.system.SpaceStation;
import imperium.map.source.resource.system.Sun;

import java.util.HashSet;
import java.util.Set;

public class DummySystemGenerator extends AbstractMapGenerator {

    public DummySystemGenerator(Seed seed) {
        super(seed);
    }

    @Override
    public Set<MapResourceInterface> generateResources() {
        Set<MapResourceInterface> resources = new HashSet<>(20);
        Sun sun = new Sun();
        sun.addSatelite(new Planet());
        sun.addSatelite(new Planet());
        Planet earthLike = new Planet();
        earthLike.addSatelite(new SpaceStation());
        earthLike.addSatelite(new SpaceStation());
        sun.addSatelite(earthLike);
        sun.addSatelite(new AsteroidBelt());
        Planet jupiterLike = new Planet();
        jupiterLike.addSatelite(new Planet());
        jupiterLike.addSatelite(new Planet());
        jupiterLike.addSatelite(new Planet());
        jupiterLike.addSatelite(new Planet());
        jupiterLike.addSatelite(new Planet());
        sun.addSatelite(jupiterLike);
        sun.addSatelite(new Planet());
        Planet saturnLike = new Planet();
        saturnLike.addSatelite(new AsteroidBelt());
        sun.addSatelite(saturnLike);
        resources.add(sun);
        return resources;
    }
}
