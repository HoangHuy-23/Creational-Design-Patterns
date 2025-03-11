package buoi02.exercise01.state;

class DeliveredState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Cập nhật trạng thái: Đã giao.");
    }
}