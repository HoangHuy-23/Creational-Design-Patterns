package buoi02.exercise01.state;

class ProcessingState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Đóng gói và vận chuyển...");
        context.setState(new DeliveredState());
    }
}