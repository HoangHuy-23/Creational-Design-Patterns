package buoi03.treestructure;

public class FileSystemTest {
    public static void main(String[] args) {
        // Tạo một số tập tin
        File file1 = new File("Document.txt", 120);
        File file2 = new File("Photo.jpg", 500);
        File file3 = new File("Video.mp4", 2048);

        // Tạo thư mục con
        Directory subDirectory = new Directory("SubFolder");
        subDirectory.addComponent(file1);
        subDirectory.addComponent(file2);

        // Tạo thư mục chính
        Directory mainDirectory = new Directory("MainFolder");
        mainDirectory.addComponent(subDirectory);
        mainDirectory.addComponent(file3);

        // Hiển thị cấu trúc thư mục
        mainDirectory.showDetails();
    }
}
