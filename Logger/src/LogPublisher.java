import java.util.ArrayList;
import java.util.List;

public class LogPublisher implements Publisher{

    private final List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscrible(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(String Message) {
        for(Subscriber s : subscribers){
            s.update(Message);
        }
    }

}
