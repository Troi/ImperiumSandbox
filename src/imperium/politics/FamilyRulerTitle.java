package imperium.politics;

import imperium.people.Human;

public class FamilyRulerTitle extends Title {
    private Family family;

    public FamilyRulerTitle(Family family) {
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public Human getRuler() {
        return family.getRuler();
    }

}
