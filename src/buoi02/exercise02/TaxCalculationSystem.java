package buoi02.exercise02;

public class TaxCalculationSystem {
    public static void main(String[] args) {

        System.out.println("=== State Pattern ===");
        StatePattern.Product laptop = new StatePattern.Product("Laptop", 1000, new StatePattern.Taxable(new StrategyPattern.VATTax()));
        laptop.displayPrice();

        StatePattern.Product book = new StatePattern.Product("Book", 500, new StatePattern.NoTax());
        book.displayPrice();


        System.out.println("\n=== Strategy Pattern ===");
        StatePattern.Product phone = new StatePattern.Product("Smartphone", 800, new StatePattern.Taxable(new StrategyPattern.LuxuryTax()));
        phone.displayPrice();

        phone.setTaxState(new StatePattern.Taxable(new StrategyPattern.ConsumptionTax()));
        phone.displayPrice();


        System.out.println("\n=== Decorator Pattern ===");
        DecoratorPattern.Tax baseTax = new DecoratorPattern.BaseTax();
        DecoratorPattern.Tax multiTax = new DecoratorPattern.LuxuryTaxDecorator(new DecoratorPattern.VATTaxDecorator(new DecoratorPattern.ConsumptionTaxDecorator(baseTax)));

        double originalPrice = 1200;
        double finalPrice = originalPrice + multiTax.applyTax(originalPrice);
        System.out.println("Luxury Product final price: $" + finalPrice);
    }
}

