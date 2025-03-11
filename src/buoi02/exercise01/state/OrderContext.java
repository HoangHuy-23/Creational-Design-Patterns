package buoi02.exercise01.state;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new NewOrderState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void processOrder() {
        state.handleOrder(this);
    }
}