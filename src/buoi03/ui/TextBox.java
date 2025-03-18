package buoi03.ui;

public class TextBox implements UIComponent {
    private String text;

    public TextBox(String text) {
        this.text = text;
    }

    @Override
    public void render() {
        System.out.println("Hộp nhập văn bản: " + text);
    }
}

