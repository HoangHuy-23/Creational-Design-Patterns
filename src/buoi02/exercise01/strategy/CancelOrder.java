package buoi02.exercise01.strategy;

class CancelOrder implements OrderStrategy {
    public void execute() {
        System.out.println("Hủy đơn hàng và xử lý hoàn tiền...");
    }
}
