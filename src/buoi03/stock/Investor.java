package buoi03.stock;

public class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    // Khi giá cổ phiếu thay đổi, nhận thông báo
    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Thông báo đến " + name + ": Cổ phiếu " + stockSymbol + " vừa thay đổi giá thành " + price);
    }
}

