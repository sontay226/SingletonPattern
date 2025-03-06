import java.io.ObjectStreamException;
import java.io.Serializable;
public class SercureSingleton implements Serializable{
    private static final long serialVersionUID = 1L;
    private static boolean isInstanceCreated = false;
    private SercureSingleton() {
        if ( isInstanceCreated ) {
            throw new RuntimeException("Instace already created , cannot create another!");
        }
        isInstanceCreated = true;
    }
    private static class SingletonHolder {
        private static final SercureSingleton INSTANCE = new SercureSingleton();
    }
    public static SercureSingleton getInstance() { return SingletonHolder.INSTANCE; }
    protected Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
