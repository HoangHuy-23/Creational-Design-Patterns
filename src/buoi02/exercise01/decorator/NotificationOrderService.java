package buoi02.exercise01.decorator;

public class NotificationOrderService extends OrderServiceDecorator {
    public NotificationOrderService(OrderService service) {
        super(service);
    }

    public void process() {
        super.process();
        System.out.println("Gửi thông báo: Đơn hàng đang xử lý");
    }
}