package LoggingSystem.Loggers;

import LoggingSystem.LogType;

public abstract class Logger {
    Logger nextLogger;
    public Logger(Logger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void log(LogType type, String message){

        if(nextLogger != null){
            nextLogger.log(type, message);
        }
    }
}
