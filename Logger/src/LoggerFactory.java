public class LoggerFactory {
    public static Logger getLogger(Publisher publisher){
        AbstractLogger debug = new DebugLogger(publisher);

        debug.setNextLogger();
    }
}
