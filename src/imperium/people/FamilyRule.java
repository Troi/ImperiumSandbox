package imperium.people;

public class FamilyRule {
    private Type type;
    private Importance importance;

    public FamilyRule(Type type, Importance importance) {
        this.type = type;
        this.importance = importance;
    }

    public Type getType() {
        return type;
    }

    public Importance getImportance() {
        return importance;
    }

    public enum Type {
        BLACKMAIL_BAN
    }

    public enum Importance {
        SUGGESTION, LAW, FANATICAL
    }
}
