public class Config {

    private static Config uniqueInstance;

    private Config() {
    }

    public static synchronized Config getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Config();

        return uniqueInstance;
    }

}
