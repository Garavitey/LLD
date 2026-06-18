public class CreditCardPaymentStrategy implements PaymentStrategyInterface{
    @Override
    public void pay() {
        System.out.println("paid using cc" );
    }
}
