public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscrible(Subscriber subscriber);
    void notifySubscriber(String Message);
}
