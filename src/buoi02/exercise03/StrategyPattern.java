package buoi02.exercise03;

public class StrategyPattern {

    interface PaymentStrategy {
        void pay(double amount);
    }


    static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card.");
        }
    }


    static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using PayPal.");
        }
    }


    static class Payment {
        private PaymentStrategy paymentStrategy;

        public Payment(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            paymentStrategy.pay(amount);
        }
    }

}
