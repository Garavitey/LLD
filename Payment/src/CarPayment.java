public class CarPayment {
    PaymentStrategyInterface paymean;

    CarPayment(PaymentStrategyInterface paymean){
        this.paymean = paymean;
    }

    void pay(){
        paymean.pay();
    }
}
