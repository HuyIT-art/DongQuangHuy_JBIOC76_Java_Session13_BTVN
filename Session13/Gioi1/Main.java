package Session13.Gioi1;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int n;
        InvoiceManager im = new InvoiceManager();

        while(true){
            System.out.println("********** MENU QUẢN LÝ HÓA ĐƠN **********");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            n = sn.nextInt();
            sn.nextLine();
            int id;
            boolean found = true;
            Invoice i = new Invoice();
            switch(n){
                case 1:
                    im.add(i);
                    break;
                case 2:
                    System.out.println("Nhập id hóa đơn cần sửa: ");
                    id = sn.nextInt();
                    sn.nextLine();
                    found = true;
                    for (int j = 0; j < im.list.size(); j++) {
                        if (im.list.get(j).id == id) {
                            im.update(id, im.list.get(j));
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Không tìm thấy hóa đơn nào có id "+id);
                    }else{
                        System.out.println("Sửa hóa đơn thành công !");
                    }
                    break;
                case 3:
                    System.out.println("Nhập id hóa đơn cần xóa: ");
                    id = sn.nextInt();
                    sn.nextLine();
                    found = true;
                    for (int j = 0; j < im.list.size(); j++) {
                        if (im.list.get(j).id == id) {
                            im.delete(id);
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Không tìm thấy hóa đơn nào có id "+id);
                    }else{
                        System.out.println("Xóa hóa đơn thành công !");
                    }
                    break;
                case 4:
                    im.display();
                    break;
                case 5:
                    System.out.println("Thoát chương trình...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại: ");
            }

        }
    }
}
