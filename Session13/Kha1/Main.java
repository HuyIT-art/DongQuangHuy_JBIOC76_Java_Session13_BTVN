package Session13.Kha1;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collection;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList();
        int n;
        Scanner sn = new Scanner(System.in);
        while (true) {
            System.out.println("********** MENU QUẢN LÝ NGƯỜI DUNG **********");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            do {
                n = sn.nextInt();
                sn.nextLine();
                if (n < 1 || n > 4) {
                    System.out.println("Nhập lại");
                }
            } while (n < 1 || n > 4);
            switch (n) {
                case 1:
                    Person p = new Person();
                    p.inputData(sn);
                    list.add(p);
                    break;
                case 2:
                    String email;
                    boolean found = false;
                    System.out.println("Nhập email người dùng để xóa: ");
                    email = sn.nextLine();
                    Iterator<Person> it = list.iterator();
                    while(it.hasNext()){
                        Person a = it.next();
                        if(a.email.equals(email)){
                            it.remove();
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Không thấy email cần xóa !");
                    }
                    break;
                case 3:
                    System.out.println("Danh sách người dùng:");
                    for(Person a: list){
                        a.outputData();
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình !");
                    System.exit(0);
                }

        }
    }
}
