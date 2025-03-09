package LoggingSystem;


import LoggingSystem.Loggers.DebugLogger;
import LoggingSystem.Loggers.ErrorLogger;
import LoggingSystem.Loggers.InfoLogger;
import LoggingSystem.Loggers.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = new ErrorLogger(new DebugLogger(new InfoLogger(null)));
        logger.log(LogType.ERROR, "Message");
    }
}
