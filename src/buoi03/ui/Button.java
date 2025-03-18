package buoi03.ui;

public class Button implements UIComponent {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void render() {
        System.out.println("Nút bấm: " + label);
    }
}

