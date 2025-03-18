package buoi03.ui;

import java.util.ArrayList;
import java.util.List;

public class Window implements UIComponent {
    private List<UIComponent> components = new ArrayList<>();

    public void addComponent(UIComponent component) {
        components.add(component);
    }

    public void removeComponent(UIComponent component) {
        components.remove(component);
    }

    @Override
    public void render() {
        System.out.println("Cửa sổ UI:");
        for (UIComponent component : components) {
            component.render();
        }
    }
}
