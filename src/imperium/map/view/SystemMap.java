package imperium.map.view;

import imperium.map.source.AbstractMapGenerator;
import imperium.map.source.DummySystemGenerator;
import imperium.map.source.Seed;

public class SystemMap extends AbstractMap {

    public SystemMap() {
        super(new DummySystemGenerator(new Seed()));
    }


}
