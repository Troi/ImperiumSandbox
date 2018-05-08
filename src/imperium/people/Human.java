package imperium.people;

public class Human {
    private String name;
    private Human mother;
    private Human father;
    private Family family;
    private Genome genome = Genome.getRandom();
    private long age = 0;
    private Long diedInAge;

    public Human(String name, Human mother, Human father, Family family) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.family = family;
    }

    public Human() {
        this.name = Name.getRandomMaleName();
        this.genome = Genome.getRandom();
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

    public Human makeOffspring(Human mother) {
        Human child = new Human(Name.getRandomMaleName(), mother, this, this.family);
        child.genome = this.genome.combine(mother.genome);
        return child;
    }
}
