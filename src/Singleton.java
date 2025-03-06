public class Singleton {
    private Singleton() {
        if ( SingletonHelper.INSTANCE != null ) {
            throw new RuntimeException("Instance already exist , cannot create more !");
        }
    }
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    public void showMessage() {
        System.out.println("Hello , Singleton");
    }
}
