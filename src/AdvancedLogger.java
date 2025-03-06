import java.io.*;

public class AdvancedLogger {
    private final String logFilePath = "application.log";
    private AdvancedLogger () {
        if ( AdvancedLoggerHepler.INSTANCE != null ) {
            throw  new RuntimeException("instace already exist ,cannot create more!");
        }
    }
    private static class AdvancedLoggerHepler {
        private static final AdvancedLogger INSTANCE = new AdvancedLogger();
    }
    public static AdvancedLogger getInstance() { return AdvancedLoggerHepler.INSTANCE; }
    public void logToFile ( String message ) {
        synchronized(this) {
            try ( BufferedWriter writer = new BufferedWriter(new FileWriter(logFilePath,true))) {
                writer.write(message);
                writer.newLine();
            }catch(IOException e ) {
                e.printStackTrace();
            }
        }
    }
    public void removeLineFromLine (  String LineToRemove ) {
        synchronized(this) {
            File originalFile = new File(logFilePath);
            File tmpFile = new File( "tmp_" + logFilePath);
            try ( BufferedReader reader = new BufferedReader(new FileReader(originalFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile))) {
                String curLine;
                while (( curLine = reader.readLine()) != null){
                    if ( curLine.trim().equals(LineToRemove)) {
                        continue;
                    }
                    writer.write(curLine);
                    writer.newLine();
                }
            }catch( IOException e ) {
                e.printStackTrace();
            }
            if ( !originalFile.delete()) {
                System.out.println("Cannot delete origin file");
                return;
            }
            if ( !tmpFile.renameTo(originalFile)) {
                System.out.println("Cannot rename temp file!");
            }
        }
    }
}
