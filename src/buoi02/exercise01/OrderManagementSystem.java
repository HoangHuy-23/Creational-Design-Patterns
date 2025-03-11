package buoi02.exercise01;
import buoi02.exercise01.decorator.*;
import buoi02.exercise01.state.*;
import buoi02.exercise01.strategy.*;

public class OrderManagementSystem {
	public static void main(String[] args) {
        // State Pattern
        OrderContext order = new OrderContext();
        order.processOrder();
        order.processOrder();
        order.processOrder();

        // Strategy Pattern
        OrderProcessor processor = new OrderProcessor();
        processor.setStrategy(new CheckOrder());
        processor.process();
        
        processor.setStrategy(new PackAndShip());
        processor.process();

        // Decorator Pattern
        OrderService service = new BasicOrderService();
        service = new LoggingOrderService(service);
        service = new NotificationOrderService(service);
        service.process();
    }
}
