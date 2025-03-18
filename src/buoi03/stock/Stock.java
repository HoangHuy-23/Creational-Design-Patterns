package buoi03.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private String symbol; // Mã cổ phiếu
    private double price; // Giá cổ phiếu
    private List<Observer> observers = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    // Đăng ký nhà đầu tư
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Hủy đăng ký nhà đầu tư
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Gửi thông báo đến tất cả nhà đầu tư
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }

    // Cập nhật giá cổ phiếu và thông báo
    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }
}

