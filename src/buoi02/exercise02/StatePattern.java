package buoi02.exercise02;

public class StatePattern {

    interface TaxState {
        double calculateTax(double price);
    }


    static class NoTax implements TaxState {
        @Override
        public double calculateTax(double price) {
            return 0;
        }
    }


    static class Taxable implements TaxState {
        private StrategyPattern.TaxStrategy taxStrategy;

        public Taxable(StrategyPattern.TaxStrategy taxStrategy) {
            this.taxStrategy = taxStrategy;
        }

        @Override
        public double calculateTax(double price) {
            return taxStrategy.calculate(price);
        }
    }


    static class Product {
        private String name;
        private double price;
        private TaxState taxState;

        public Product(String name, double price, TaxState taxState) {
            this.name = name;
            this.price = price;
            this.taxState = taxState;
        }

        public void setTaxState(TaxState taxState) {
            this.taxState = taxState;
        }

        public double getFinalPrice() {
            return price + taxState.calculateTax(price);
        }

        public void displayPrice() {
            System.out.println(name + " final price: $" + getFinalPrice());
        }
    }

}
