package Session13;

import java.util.LinkedList;
import java.util.Scanner;

class Person {
    private String name;
    private String email;
    private String phone;

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void display() {
        System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone);
    }
}
public class Kha1{
public class Main {
    static LinkedList<Person> list = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa theo email");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    deleteByEmail();
                    break;
                case 3:
                    displayList();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);
    }

    // Thêm người dùng
    public static void addPerson() {
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();

        list.add(new Person(name, email, phone));
        System.out.println("Đã thêm thành công!");
    }

    // Xóa theo email
    public static void deleteByEmail() {
        System.out.print("Nhập email cần xóa: ");
        String email = sc.nextLine();

        boolean found = false;

        for (Person p : list) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                list.remove(p);
                found = true;
                System.out.println("Đã xóa!");
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy email!");
        }
    }

    // Hiển thị danh sách
    public static void displayList() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        System.out.println("\n--- Danh sách người dùng ---");
        for (Person p : list) {
            p.display();
        }
    }
}
}