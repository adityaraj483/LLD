package LoggingSystem.Loggers;

import LoggingSystem.LogType;

public class ErrorLogger extends Logger{
    public ErrorLogger(Logger nextLogger) {
        super(nextLogger);
    }

    public void log(LogType type , String message){
        if(type == LogType.ERROR){
            System.out.println("ERROR Logger: "+message);
        }else
            super.log(type, message);
    }
}
