package imperium.people;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private String name;
    private Human ruler;
    private List<FamilyRule> rules = new ArrayList<>(0);

    public Family(Human ruler) {
        this.name = ruler.getName();
        this.ruler = ruler;
    }

    public String getName() {
        return name;
    }

    public Human getRuler() {
        return ruler;
    }

    public List<FamilyRule> getRules() {
        return rules;
    }
}
