package imperium.map.source;

import imperium.map.source.resource.MapResourceInterface;

import java.util.Collections;
import java.util.Set;

public abstract class AbstractMapGenerator {
    private final Seed seed;

    public AbstractMapGenerator(Seed seed) {
        this.seed = seed;
    }

    public Set<MapResourceInterface> generateResources() {
        return Collections.emptySet();
    }
}
