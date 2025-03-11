package buoi02.exercise02;

public class StrategyPattern {

    interface TaxStrategy {
        double calculate(double price);
    }


    static class ConsumptionTax implements TaxStrategy {
        @Override
        public double calculate(double price) {
            return price * 0.1;
        }
    }


    static class VATTax implements TaxStrategy {
        @Override
        public double calculate(double price) {
            return price * 0.15;
        }
    }


    static class LuxuryTax implements TaxStrategy {
        @Override
        public double calculate(double price) {
            return price * 0.25;
        }
    }

}
