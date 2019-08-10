package factories;

public class LocaleFactory {
    private static volatile LocaleFactory factory = null;

    private LocaleFactory() {

    }

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
