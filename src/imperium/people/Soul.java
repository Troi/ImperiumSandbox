package imperium.people;

import java.util.List;

public class Soul {
    private String name;
    private Human currentIncarnation;
    private List<Human> lifesHistory;

    public Soul(String name, Human currentIncarnation, List<Human> lifesHistory) {
        this.name = name;
        this.currentIncarnation = currentIncarnation;
        this.lifesHistory = lifesHistory;
    }

    public Soul(String name, Human currentIncarnation) {
        this.name = name;
        this.currentIncarnation = currentIncarnation;
    }

    public String getName() {
        return name;
    }

    public Human getCurrentIncarnation() {
        return currentIncarnation;
    }

    public List<Human> getLifesHistory() {
        return lifesHistory;
    }

    public void setCurrentIncarnation(Human currentIncarnation) {
        this.currentIncarnation = currentIncarnation;
        this.lifesHistory.add(currentIncarnation);
    }

    public void setLifesHistory(List<Human> lifesHistory) {
        this.lifesHistory = lifesHistory;
    }

}
