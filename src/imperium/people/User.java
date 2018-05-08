package imperium.people;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Soul> souls;

    public User(String username, List<Soul> souls) {
        this.username = username;
        this.souls = souls;
    }

    public User(String username) {
        this.username = username;
        this.souls = new ArrayList<>(1);
    }

    public String getUsername() {
        return username;
    }

    public List<Soul> getSouls() {
        return souls;
    }

    public void addSouls(Soul soul) {
        this.souls.add(soul);
    }
}
