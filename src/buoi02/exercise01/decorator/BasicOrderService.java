package buoi02.exercise01.decorator;

public class BasicOrderService implements OrderService {
    public void process() {
        System.out.println("Xử lý đơn hàng...");
    }
}