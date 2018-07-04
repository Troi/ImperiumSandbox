package imperium.map.view;

import imperium.map.source.AbstractMapGenerator;
import imperium.map.source.resource.MapResourceInterface;
import imperium.people.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class AbstractMap {
    private Set<MapResourceInterface> resources;
    private AbstractMapGenerator generator;

    public AbstractMap(Set<MapResourceInterface> resources) {
        this.resources = resources;
    }

    public AbstractMap(AbstractMapGenerator generator) {
        this.generator = generator;
    }

    public AbstractMap() {
        this.resources = Collections.emptySet();
    }

    public Set<MapResourceInterface> getResources() {
        if (this.resources == null) {
            resources = this.generator.generateResources();
        }
        return resources;
    }

    public List<PoliticMapResourceDecorator> getPersonalizedResources(Human whoIsLooking) {
        List<PoliticMapResourceDecorator> properties = new ArrayList<>(getResources().size());
        for (MapResourceInterface resource: getResources()) {
            properties.add(new PoliticMapResourceDecorator(resource));
        }
        return properties;
    }
}
