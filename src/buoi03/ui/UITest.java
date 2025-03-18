package buoi03.ui;

public class UITest {
    public static void main(String[] args) {
        // Tạo các thành phần cơ bản
        Button button1 = new Button("Đăng nhập");
        Button button2 = new Button("Đăng ký");
        TextBox textBox = new TextBox("Nhập email của bạn...");

        // Tạo Panel và thêm thành phần vào Panel
        Panel panel = new Panel();
        panel.addComponent(button1);
        panel.addComponent(button2);
        panel.addComponent(textBox);

        // Tạo cửa sổ UI và thêm panel vào
        Window window = new Window();
        window.addComponent(panel);
        
        // Hiển thị toàn bộ UI
        window.render();
    }
}

