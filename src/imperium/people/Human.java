package imperium.people;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human mother;
    private Human father;
    private Family family;
    private List<Human> children = new ArrayList<>(0);
    private Genome genome = Genome.getRandom();
    private long age = 0;
    private Long diedInAge;

    private Human(String name, Human mother, Human father, Family family) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.family = family;
    }

    public Human() {
        this.name = Name.getRandomMaleName();
        this.genome = Genome.getRandom();
        this.family = new Family(this);
    }

    public String getName() {
        return name;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Family getFamily() {
        return family;
    }

    public long getAge() {
        return age;
    }

    public void age() {
        age++;
    }

    public void die() {
        diedInAge = age;
    }

    public long getLifeLength() {
        if (diedInAge == null) {
            return age;
        }
        return diedInAge;
    }

    public boolean isAlive() {
        return (diedInAge == null);
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human makeOffspring(Human mother) {
        Human child = new Human(Name.getRandomMaleName(), mother, this, this.family);
        this.children.add(child);
        mother.children.add(child);
        child.genome = this.genome.combine(mother.genome);
        return child;
    }

    public boolean isAncestor(Human human) {
        boolean directRelationship = (human == this);
        if (father != null) {
            directRelationship = directRelationship || father.isAncestor(human);
        }
        if (mother != null) {
            directRelationship = directRelationship || mother.isAncestor(human);
        }
        return directRelationship;
    }

    private int getPreviousGenerationsCount() {
        int pgf = 0;
        int pgm = 0;
        if (father != null) {
            pgf = 1 + father.getPreviousGenerationsCount();
        }
        if (mother != null) {
            pgm = 1 + mother.getPreviousGenerationsCount();
        }
        return Math.max(pgf, pgm);
    }

    @Override
    public String toString() {
        return name + " from " + family.getName() + " (age: " + age + ", generation: " + this.getPreviousGenerationsCount() + ")";
    }
}
