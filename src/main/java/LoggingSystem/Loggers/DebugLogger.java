package LoggingSystem.Loggers;

import LoggingSystem.LogType;

public class DebugLogger extends Logger{
    public DebugLogger(Logger nextLogger) {
        super(nextLogger);
    }
    public void log(LogType type, String message){
        if(type == LogType.DEBUG)
            System.out.println("DEBUG Logger: "+message);
        else
            super.log(type, message);
    }
}
