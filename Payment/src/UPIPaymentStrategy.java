public class UPIPaymentStrategy implements PaymentStrategyInterface {

    @Override
    public void pay() {
        System.out.println("paid using upi");
    }
}
