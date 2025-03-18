package buoi03.task;

import java.util.ArrayList;
import java.util.List;

public class Task implements Subject {
    private String name; // Tên công việc
    private String status; // Trạng thái công việc (Todo, In Progress, Done)
    private List<Observer> observers = new ArrayList<>();

    public Task(String name, String status) {
        this.name = name;
        this.status = status;
    }

    // Đăng ký thành viên nhận thông báo
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    // Hủy đăng ký thành viên
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Gửi thông báo đến tất cả thành viên trong nhóm
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name, status);
        }
    }

    // Cập nhật trạng thái công việc và thông báo đến thành viên nhóm
    public void setStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("\n📌 Công việc '" + name + "' cập nhật trạng thái: " + status);
        notifyObservers();
    }
}
