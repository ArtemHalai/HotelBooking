package factories;

/**
 * A class that provides factory to get necessary locale.
 */
public class LocaleFactory {

    /**
     * Static instance of this class.
     */
    private static volatile LocaleFactory factory = null;

    /**
     * Private constructor to prevent
     * the instantiation of this class directly
     */
    private LocaleFactory() {

    }

    /**
     * Gets the instance of factory.
     *
     * @return the instance of {@link #factory}.
     */
    public static LocaleFactory getInstance() {
        if (factory == null) {
            synchronized (LocaleFactory.class) {
                if (factory == null) {
                    factory = new LocaleFactory();
                }
            }
        }
        return factory;
    }

    /**
     * Gets the locale.
     *
     * @param locale The string value to get locale or default value.
     * @return the string value of locale associated with given parameter.
     */
    public String getLocale(String locale) {
        switch (locale) {
            case "ua":
                return "ua";
            case "ru":
                return "ru";
            default:
                return "en";
        }
    }
}
