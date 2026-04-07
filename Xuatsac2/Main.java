package Session13.Xuatsac2;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        int n;
        Set<Contact> list = new HashSet<>();
        while(true){
            System.out.println("1. Thêm liên lạc");
            System.out.println("2. Xóa liên lạc theo số điện thoại");
            System.out.println("3. Tìm kiếm liên lạc");
            System.out.println("4. In danh sách liên lạc");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            n = sn.nextInt();
            sn.nextLine();
            String phone;
            boolean found = true;
            switch(n){
                case 1:
                    Contact t = new Contact();
                    t.inputData(sn);
                    list.add(t);
                    break;
                case 2:
                    found = true;
                    System.out.println("Nhập số điện thoại cần xóa: ");
                    phone = sn.nextLine();
                    Iterator<Contact> it = list.iterator();
                    while(it.hasNext()){
                        Contact a = it.next();
                        if(a.getPhoneNumber().equals(phone))  {
                            it.remove();
                            found = false;
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Không tìm thấy số điện thoại !");
                    }else{
                        System.out.println("Xóa liên lạc thành công !");
                    }
                    break;
                case 3:
                    found = true;
                    System.out.println("Nhập số điện thoại cần tìm: ");
                    phone = sn.nextLine();
                    for (Contact c : list) {
                        if (c.getPhoneNumber().equals(phone)) {
                            System.out.println(c);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy số điện thoại!");
                    }
                    if(found){
                        System.out.println("Không tìm thấy số điện thoại !");
                    }
                    break;
                case 4:
                    System.out.println("Danh sách liên lạc");
                    for(Contact c: list){
                        System.out.println(c);
                    }
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
