package buoi02.exercise01.strategy;

public class PackAndShip implements OrderStrategy {
    public void execute() {
        System.out.println("Đóng gói và vận chuyển đơn hàng...");
    }
}