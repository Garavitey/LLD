public class DebugLogger extends AbstractLogger{

    public DebugLogger(Publisher publisher){
        super(LogLevel.DEBUG, publisher);
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG" + message);
    }
}
