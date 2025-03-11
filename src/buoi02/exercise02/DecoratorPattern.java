package buoi02.exercise02;

public class DecoratorPattern {

    interface Tax {
        double applyTax(double price);
    }


    static class BaseTax implements Tax {
        @Override
        public double applyTax(double price) {
            return 0;
        }
    }


    static class ConsumptionTaxDecorator implements Tax {
        private Tax tax;

        public ConsumptionTaxDecorator(Tax tax) {
            this.tax = tax;
        }

        @Override
        public double applyTax(double price) {
            return tax.applyTax(price) + price * 0.1;
        }
    }


    static class VATTaxDecorator implements Tax {
        private Tax tax;

        public VATTaxDecorator(Tax tax) {
            this.tax = tax;
        }

        @Override
        public double applyTax(double price) {
            return tax.applyTax(price) + price * 0.15;
        }
    }


    static class LuxuryTaxDecorator implements Tax {
        private Tax tax;

        public LuxuryTaxDecorator(Tax tax) {
            this.tax = tax;
        }

        @Override
        public double applyTax(double price) {
            return tax.applyTax(price) + price * 0.25;
        }
    }

}
