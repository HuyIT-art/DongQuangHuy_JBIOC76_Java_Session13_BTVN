package Session13;

import java.util.ArrayList;
import java.util.Scanner;

// Interface Generic
interface Manage<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}

// Lớp Student
class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Tên sinh viên: " + name);
    }
}

// Lớp quản lý Attendance
class AttendanceManager implements Manage<Student> {
    private ArrayList<Student> list = new ArrayList<>();

    @Override
    public void add(Student item) {
        list.add(item);
    }

    @Override
    public void update(int index, Student item) {
        if (index >= 0 && index < list.size()) {
            list.set(index, item);
        } else {
            System.out.println("Index không hợp lệ!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Index không hợp lệ!");
        }
    }

    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).display();
        }
    }
}

// Main (menu)
public class Kha2 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            AttendanceManager manager = new AttendanceManager();
            int choice;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Thêm sinh viên");
                System.out.println("2. Sửa sinh viên");
                System.out.println("3. Xóa sinh viên");
                System.out.println("4. Hiển thị danh sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập tên sinh viên: ");
                        String name = sc.nextLine();
                        manager.add(new Student(name));
                        break;

                    case 2:
                        System.out.print("Nhập vị trí cần sửa: ");
                        int updateIndex = Integer.parseInt(sc.nextLine()) - 1;
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine();
                        manager.update(updateIndex, new Student(newName));
                        break;

                    case 3:
                        System.out.print("Nhập vị trí cần xóa: ");
                        int deleteIndex = Integer.parseInt(sc.nextLine()) - 1;
                        manager.delete(deleteIndex);
                        break;

                    case 4:
                        manager.display();
                        break;

                    case 0:
                        System.out.println("Thoát chương trình.");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } while (choice != 0);
        }
    }
}