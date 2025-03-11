package buoi02.exercise03;

public class StatePattern {

    interface PaymentState {
        void processPayment();
    }


    static class PendingPayment implements PaymentState {
        @Override
        public void processPayment() {
            System.out.println("Payment is pending...");
        }
    }


    static class SuccessfulPayment implements PaymentState {
        @Override
        public void processPayment() {
            System.out.println("Payment was successful!");
        }
    }


    static class FailedPayment implements PaymentState {
        @Override
        public void processPayment() {
            System.out.println("Payment failed. Please try again.");
        }
    }


    static class PaymentContext {
        private PaymentState state;

        public PaymentContext() {
            this.state = new PendingPayment(); // Mặc định đang chờ xử lý
        }

        public void setState(PaymentState state) {
            this.state = state;
        }

        public void processPayment() {
            state.processPayment();
        }
    }

}
