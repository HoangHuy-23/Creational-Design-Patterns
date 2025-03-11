package exercise01;

class DeliveredState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Cập nhật trạng thái: Đã giao.");
    }
}