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
        int solarRadiusCounter = 1;
        Sun sun = new Sun();
        sun.addSatelite(new Planet(), solarRadiusCounter++);
        sun.addSatelite(new Planet(), solarRadiusCounter++);
        Planet earthLike = new Planet();
        earthLike.addSatelite(new SpaceStation(), 1);
        earthLike.addSatelite(new SpaceStation(), 2);
        sun.addSatelite(earthLike, solarRadiusCounter++);
        sun.addSatelite(new AsteroidBelt(), solarRadiusCounter++);

        Planet jupiterLike = new Planet();
        jupiterLike.addSatelite(new Planet(), 1);
        jupiterLike.addSatelite(new Planet(),2);
        jupiterLike.addSatelite(new Planet(),3);
        jupiterLike.addSatelite(new Planet(), 4);
        jupiterLike.addSatelite(new Planet(), 5);
        sun.addSatelite(jupiterLike, solarRadiusCounter++);
        sun.addSatelite(new Planet(), solarRadiusCounter++);
        Planet saturnLike = new Planet();
        saturnLike.addSatelite(new AsteroidBelt(), 1);
        sun.addSatelite(saturnLike, solarRadiusCounter++);
        resources.add(sun);
        return resources;
    }
}
