import java.util.concurrent.Flow;

public abstract class AbstractLogger implements Logger {
    protected LogLevel level;
    protected Logger nextLogger;
    protected Publisher publisher;

    public AbstractLogger(LogLevel level, Publisher publisher){
        this.level = level;
        this.publisher = publisher;
    }

    public void setNextLogger(Logger nextLogger){
        this.nextLogger = nextLogger;
    }

    protected abstract void write(String message);

    @Override
    public void log(LogLevel level, String message){
        if(this.level.getLevel() == level.getLevel()){
            write(message);
            publisher.notifySubscriber(message);
        }
        if(nextLogger != null){
            nextLogger.log(level, message);
        }
    }
}
