package LoggingSystem.Loggers;

import LoggingSystem.LogType;

public class InfoLogger extends Logger{
    public InfoLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LogType type, String message){
        if(type == LogType.INFO)
            System.out.println("INFO Logger: "+message);
        else
            super.log(type, message);
    }
}
