package enums;

/**
 *  Role that can be used
 *  <li>{@link #GUEST}</li>
 *  <li>{@link #ADMIN}</li>
 */
public enum Role {
    /**
     * Guest role
     */
    GUEST("GUEST"),
    /**
     * Admin role
     */
    ADMIN("ADMIN");

    private String name;

    /**
     * Sole constructor. It is not possible to invoke this constructor.
     * It is for use by code emitted by the compiler in response to enum type declarations.
     * @param name The name of enum constant, which is the identifier used to declare it.
     */
    Role(String name) {
        this.name = name;
    }

    /**
     * Gets the value of {@link #name}.
     *
     * @return the value of {@link #name}.
     */
    public String getName(){
        return name;
    }
}
