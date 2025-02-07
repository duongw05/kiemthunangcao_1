package bai3;

public class Profile {
    String name;

    public Profile(String name) {
        this.name = name;
    }

    public Profile() {
    }

    public String getName() {
        if (name == null) {
            throw new NullPointerException("Profile name is null");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
