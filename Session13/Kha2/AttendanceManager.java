package Session13.Kha2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class AttendanceManager implements Manage<Student> {
    ArrayList<Student> list = new ArrayList<>();

    public void add(Student item) {
        Scanner sn = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Nhập id sinh viên: ");
                item.setId(sn.nextInt());
                sn.nextLine();
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                System.out.println("Nhập tên sinh viên: ");
                item.setName(sn.nextLine());
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        list.add(item);
        System.out.println("Sinh viên đã được thêm thành công.");
    }

    public void update(int index, Student item) {
        Scanner sn = new Scanner(System.in);
        boolean found = true;
        if (item.id == index) {
            System.out.println("Nhập tên mới sinh viên:");
            item.setName(sn.nextLine());
            found = false;
        }
        if (found) {
            System.out.println("Không tìm thấy id sinh viên !");
        } else {
            System.out.println("Sinh viên đã được sửa thành công.");
        }

    }

    public void delete(int index) {
        Scanner sn = new Scanner(System.in);
        boolean found = true;
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == index) {
                it.remove();
                found = false;
            }
        }
        if (found) {
            System.out.println("Không tìm thấy id sinh viên !");
        } else {
            System.out.println("Đã xóa thành công sinh viên !");
        }
    }

    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("ID : " + list.get(i).id +
                    " , Tên sinh viên: " + list.get(i).name);
        }

    }
}
