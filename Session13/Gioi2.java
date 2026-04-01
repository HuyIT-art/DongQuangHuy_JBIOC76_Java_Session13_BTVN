package Session13
import java.util.ArrayList;
import java.util.Scanner;

// Interface Generic
interface Managess<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}

// Lớp Order
class Order {
    private String id;
    private String customerName;

    public Order(String id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public void display() {
        System.out.println("Mã đơn: " + id + " | Khách hàng: " + customerName);
    }
}

// Lớp quản lý Order
class OrderManager implements Manage<Order> {
    private ArrayList<Order> list = new ArrayList<>();

    @Override
    public void add(Order item) {
        list.add(item);
    }

    @Override
    public void update(int index, Order item) {
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
            System.out.println("Danh sách đơn hàng trống!");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).display();
        }
    }
}

// Main (menu)
public class Gioi2 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            OrderManager manager = new OrderManager();
            int choice;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Thêm đơn hàng");
                System.out.println("2. Sửa đơn hàng");
                System.out.println("3. Xóa đơn hàng");
                System.out.println("4. Hiển thị danh sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Nhập mã đơn: ");
                        String id = sc.nextLine();

                        System.out.print("Nhập tên khách hàng: ");
                        String name = sc.nextLine();

                        manager.add(new Order(id, name));
                        break;

                    case 2:
                        System.out.print("Nhập vị trí cần sửa: ");
                        int updateIndex = Integer.parseInt(sc.nextLine()) - 1;

                        System.out.print("Nhập mã mới: ");
                        String newId = sc.nextLine();

                        System.out.print("Nhập tên khách hàng mới: ");
                        String newName = sc.nextLine();

                        manager.update(updateIndex, new Order(newId, newName));
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