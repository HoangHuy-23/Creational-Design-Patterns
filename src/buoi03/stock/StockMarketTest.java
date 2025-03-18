package buoi03.stock;

public class StockMarketTest {
    public static void main(String[] args) {
        // Tạo cổ phiếu
        Stock appleStock = new Stock("AAPL", 150.0);

        // Tạo nhà đầu tư
        Investor investor1 = new Investor("Nguyễn Văn A");
        Investor investor2 = new Investor("Trần Thị B");

        // Nhà đầu tư đăng ký nhận thông báo từ cổ phiếu
        appleStock.registerObserver(investor1);
        appleStock.registerObserver(investor2);

        // Giá cổ phiếu thay đổi
        System.out.println("\n📌 Giá cổ phiếu thay đổi lần 1:");
        appleStock.setPrice(155.0);

        // Nhà đầu tư B hủy đăng ký theo dõi
        appleStock.removeObserver(investor2);

        // Giá cổ phiếu thay đổi lần 2
        System.out.println("\n📌 Giá cổ phiếu thay đổi lần 2:");
        appleStock.setPrice(160.0);
    }
}

