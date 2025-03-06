//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AdvancedLogger logger = AdvancedLogger.getInstance();
        logger.logToFile("first log!");
        logger.logToFile("second log!");
        System.out.println("Log has been save to file application.log!");
    }
}