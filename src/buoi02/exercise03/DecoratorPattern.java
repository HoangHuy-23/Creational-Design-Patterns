package buoi02.exercise03;

public class DecoratorPattern {

    interface PaymentFeature {
        double apply(double amount);
    }


    static class BasicPayment implements PaymentFeature {
        @Override
        public double apply(double amount) {
            return amount;
        }
    }

    // Decorator: Thêm phí xử lý
    static class ProcessingFeeDecorator implements PaymentFeature {
        private PaymentFeature paymentFeature;

        public ProcessingFeeDecorator(PaymentFeature paymentFeature) {
            this.paymentFeature = paymentFeature;
        }

        @Override
        public double apply(double amount) {
            return paymentFeature.apply(amount) + amount * 0.02; // Phí xử lý 2%
        }
    }


    static class DiscountDecorator implements PaymentFeature {
        private PaymentFeature paymentFeature;

        public DiscountDecorator(PaymentFeature paymentFeature) {
            this.paymentFeature = paymentFeature;
        }

        @Override
        public double apply(double amount) {
            return paymentFeature.apply(amount) - 10; // Giảm giá $10
        }
    }

}
