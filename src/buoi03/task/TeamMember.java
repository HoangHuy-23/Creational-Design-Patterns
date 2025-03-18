package buoi03.task;

public class TeamMember implements Observer {
    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    // Khi trạng thái công việc thay đổi, nhận thông báo
    @Override
    public void update(String taskName, String status) {
        System.out.println("🔔 Thông báo đến " + name + ": Công việc '" + taskName + "' đã thay đổi trạng thái thành '" + status + "'");
    }
}
