package buoi02.exercise01.decorator;

public class LoggingOrderService extends OrderServiceDecorator {
    public LoggingOrderService(OrderService service) {
        super(service);
    }

    public void process() {
        super.process();
        System.out.println("Ghi log: Đơn hàng đã được xử lý");
    }
}