package Session13;

import java.util.ArrayList;
import java.util.Scanner;

// Interface Generic
interface Manages<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}

// Lớp Invoice
class Invoice {
    private String id;
    private double amount;

    public Invoice(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public void display() {
        System.out.println("Mã HĐ: " + id + " | Số tiền: " + amount);
    }
}

// Lớp quản lý Invoice
class InvoiceManager implements Manage<Invoice> {
    private ArrayList<Invoice> list = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        list.add(item);
    }

    @Override
    public void update(int index, Invoice item) {
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
            System.out.println("Danh sách hóa đơn trống!");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).display();
        }
    }
}

// Main (menu)
public class Gioi1 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            InvoiceManager manager = new InvoiceManager();
            int choice;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Thêm hóa đơn");
                System.out.println("2. Sửa hóa đơn");
                System.out.println("3. Xóa hóa đơn");
                System.out.println("4. Hiển thị danh sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập mã hóa đơn: ");
                        String id = sc.nextLine();

                        System.out.print("Nhập số tiền: ");
                        double amount = Double.parseDouble(sc.nextLine());

                        manager.add(new Invoice(id, amount));
                        break;

                    case 2:
                        System.out.print("Nhập vị trí cần sửa: ");
                        int updateIndex = Integer.parseInt(sc.nextLine()) - 1;

                        System.out.print("Nhập mã mới: ");
                        String newId = sc.nextLine();

                        System.out.print("Nhập số tiền mới: ");
                        double newAmount = Double.parseDouble(sc.nextLine());

                        manager.update(updateIndex, new Invoice(newId, newAmount));
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