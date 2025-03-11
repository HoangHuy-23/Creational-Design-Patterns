package buoi02.exercise01.strategy;

public class CheckOrder implements OrderStrategy {
    public void execute() {
        System.out.println("Kiểm tra đơn hàng trước khi xử lý...");
    }
}