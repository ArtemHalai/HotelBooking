package enums;

public enum Role {
    GUEST("GUEST"),
    ADMIN("ADMIN");

    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
