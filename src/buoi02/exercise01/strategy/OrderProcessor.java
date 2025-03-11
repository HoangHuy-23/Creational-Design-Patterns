package buoi02.exercise01.strategy;

public class OrderProcessor {
    private OrderStrategy strategy;

    public void setStrategy(OrderStrategy strategy) {
        this.strategy = strategy;
    }

    public void process() {
        strategy.execute();
    }
}