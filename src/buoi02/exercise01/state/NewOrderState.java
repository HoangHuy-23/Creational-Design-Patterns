package buoi02.exercise01.state;

class NewOrderState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Kiểm tra thông tin đơn hàng...");
        context.setState(new ProcessingState());
    }
}