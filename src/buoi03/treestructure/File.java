package buoi03.treestructure;

public class File implements FileSystemComponent {
    private String name;
    private int size; // Dung lượng tập tin (đơn vị: KB)

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("- Tập tin: " + name + " (" + size + "KB)");
    }
}

