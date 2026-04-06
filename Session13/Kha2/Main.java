package Session13.Kha2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        AttendanceManager a = new AttendanceManager();
        int n;
        while(true){
            System.out.println("********** MENU QUẢN LÝ ĐIỂM DANH **********");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn cảu bạn: ");
            n = sn.nextInt();
            sn.nextLine();
            Student item = new Student();
            int index;
            switch(n){
                case 1:
                    a.add(item);
                    break;
                case 2:
                    System.out.println("Nhập id sinh viên cần sửa: ");
                    index = sn.nextInt();
                    sn.nextLine();
                    for (int i = 0; i < a.list.size(); i++) {
                        a.update(index,a.list.get(i));
                    }
                    a.update(index,item);
                    break;
                case 3:
                    System.out.println("Nhập id sinh viên cần xóa: ");
                    index = sn.nextInt();
                    sn.nextLine();
                    a.delete(index);
                    break;
                case 4:
                    a.display();
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                default:
                    System.out.println("Nhập lại lựa chọn: ");

            }
        }
    }
}
