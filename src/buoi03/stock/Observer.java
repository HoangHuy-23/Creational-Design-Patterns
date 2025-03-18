package buoi03.stock;

public interface Observer {
    void update(String stockSymbol, double price);
}
