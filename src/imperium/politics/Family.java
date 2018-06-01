package imperium.politics;

import com.sun.istack.internal.NotNull;
import imperium.people.Human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Family {
    private String name;
    private Human ruler;
    private OrderOfSuccession succession = OrderOfSuccession.PRIMOGENITURE;
    private SuccessionFilter successionFilter = SuccessionFilter.EQUAL;
    private List<FamilyRule> rules = new ArrayList<>(0);

    public Family(Human ruler) {
        this.name = ruler.getName();
        this.ruler = ruler;
    }

    public static void humanDeath(@NotNull Human human) {
        List<Property> heritage = human.getProperties();
        human.die();

        Human heir = getHeir(human);
        if (heir == null) {
            noHeirHeritage(human, heritage);
            return;
        }

        if (human == human.getFamily().getRuler()) {
            human.getFamily().setRuler(heir);
        }
        heir.getProperties().addAll(heritage);
    }

    public static void noHeirHeritage(@NotNull Human human, List<Property> heritage) {
        // TODO: rozdat vazalum nebo spravcum
    }

    public static Human getHeir(@NotNull Human human) {
        List<Human> availableHeirs = new ArrayList<>();

        for (Human child : human.getChildren()) {
            if (!child.isAlive()) continue;
            switch (human.getFamily().successionFilter) {
                case EQUAL:
                case MALE_PREFERED:
                case FEMALE_PREFERED:
                case MALE_ONLY:
                case FEMALE_ONLY:
                    availableHeirs.add(child);
            }
        }
        if (availableHeirs.isEmpty()) {
            return null;
        }

        OrderOfSuccession familySuccession = OrderOfSuccession.PRIMOGENITURE;
        if (human.getFamily() != null) {
            familySuccession = human.getFamily().succession;
        }

        switch (familySuccession) {
            case PRIMOGENITURE:
                availableHeirs.sort(new Comparator<Human>() {
                    @Override
                    public int compare(Human o1, Human o2) {
                        return Long.compare(o1.getAge(), o2.getAge());
                    }
                });
                break;
            case ULTIMOGENITURE:
                availableHeirs.sort(new Comparator<Human>() {
                    @Override
                    public int compare(Human o1, Human o2) {
                        return Long.compare(o2.getAge(), o1.getAge());
                    }
                });
                break;

        }
        return availableHeirs.iterator().next();
    }

    public String getName() {
        return name;
    }

    public Human getRuler() {
        return ruler;
    }

    private void setRuler(Human ruler) {
        this.ruler = ruler;
    }

    public Human getHeir() {
        return getHeir(ruler);
    }

    public List<FamilyRule> getRules() {
        return rules;
    }

    /**
     * https://en.wikipedia.org/wiki/Order_of_succession
     */
    public enum OrderOfSuccession {
        PRIMOGENITURE, ULTIMOGENITURE, ELECTION_BY_DISTANCE, ELECTION_BY_MONEY
    }

    public enum SuccessionFilter {
        MALE_ONLY, MALE_PREFERED, EQUAL, FEMALE_PREFERED, FEMALE_ONLY
    }

}
