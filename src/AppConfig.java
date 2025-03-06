import java.util.HashMap;
import java.util.Map;
public class AppConfig {
    private Map<String , String > configs = new HashMap<>();
    private AppConfig () {
        if ( AppConfigHelper.INSTANCE != null ) {
            throw  new RuntimeException("instance already exist , cannot create more !");
        }
    }
    private static class AppConfigHelper  {
        private static final AppConfig INSTANCE = new AppConfig();
    }
    public static AppConfig getInstance() { return AppConfigHelper.INSTANCE; }
    public String getConfig ( String key ) {
        return configs.get(key);
    }
    public void setConfig ( String key , String value ) {
        configs.put(key , value);
    }
}
