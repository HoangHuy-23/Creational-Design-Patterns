package buoi02.exercise01.state;

class CanceledState implements OrderState {
    public void handleOrder(OrderContext context) {
        System.out.println("Hủy đơn hàng và hoàn tiền...");
    }
}