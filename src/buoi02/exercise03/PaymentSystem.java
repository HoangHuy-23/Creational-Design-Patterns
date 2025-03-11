package buoi02.exercise03;

public class PaymentSystem {
    public static void main(String[] args) {

        System.out.println("=== State Pattern ===");
        StatePattern.PaymentContext paymentContext = new StatePattern.PaymentContext();
        paymentContext.processPayment();

        paymentContext.setState(new StatePattern.SuccessfulPayment());
        paymentContext.processPayment();

        paymentContext.setState(new StatePattern.FailedPayment());
        paymentContext.processPayment();


        System.out.println("\n=== Strategy Pattern ===");
        StrategyPattern.Payment creditCardPayment = new StrategyPattern.Payment(new StrategyPattern.CreditCardPayment());
        creditCardPayment.executePayment(100);

        StrategyPattern.Payment payPalPayment = new StrategyPattern.Payment(new StrategyPattern.PayPalPayment());
        payPalPayment.executePayment(200);


        System.out.println("\n=== Decorator Pattern ===");
        DecoratorPattern.PaymentFeature basePayment = new DecoratorPattern.BasicPayment();
        DecoratorPattern.PaymentFeature paymentWithFee = new DecoratorPattern.ProcessingFeeDecorator(basePayment);
        DecoratorPattern.PaymentFeature paymentWithFeeAndDiscount = new DecoratorPattern.DiscountDecorator(paymentWithFee);

        double originalAmount = 500;
        double finalAmount = paymentWithFeeAndDiscount.apply(originalAmount);

        System.out.println("Final amount after processing fee and discount: $" + finalAmount);
    }
}
