package imperium.map.source.resource.system;

public class Orbit {
    private final AbstractGravityObject centralObject;
    private final long radius;
    private final long offset;

    public Orbit(AbstractGravityObject centralObject, long radius, long offset) {
        this.centralObject = centralObject;
        this.radius = radius;
        this.offset = offset;
    }

    public AbstractGravityObject getCentralObject() {
        return centralObject;
    }

    public long getRadius() {
        return radius;
    }

    public long getOffset() {
        return offset;
    }

    public long getOrbitPeriod() {
        double orbitLength = 2*Math.PI*radius;
        double velocity = centralObject.getMass()*centralObject.getG()/radius;
        return Math.round(orbitLength/velocity);
    }

}
