package imperium.people;

class Genome {

    private Genome() {
    }

    public static Genome getRandom() {
        return new Genome();
    }

    public Genome combine(Genome second) {
        return new Genome();
    }
}
