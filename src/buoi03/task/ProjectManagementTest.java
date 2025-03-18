package buoi03.task;

public class ProjectManagementTest {
    public static void main(String[] args) {
        // Tạo công việc
        Task task1 = new Task("Phát triển giao diện", "Todo");

        // Tạo thành viên nhóm
        TeamMember member1 = new TeamMember("Nguyễn Văn A");
        TeamMember member2 = new TeamMember("Trần Thị B");

        // Thành viên đăng ký theo dõi công việc
        task1.registerObserver(member1);
        task1.registerObserver(member2);

        // Cập nhật trạng thái công việc
        task1.setStatus("In Progress");

        // Thành viên B hủy đăng ký theo dõi
        task1.removeObserver(member2);

        // Cập nhật trạng thái công việc lần 2
        task1.setStatus("Done");
    }
}
