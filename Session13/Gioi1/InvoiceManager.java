package Session13.Gioi1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.Iterator;

public class InvoiceManager implements Manage<Invoice> {
    ArrayList<Invoice> list = new ArrayList<>();
    Scanner sn = new Scanner(System.in);

    //Phương thức thêm
    @Override
    public void add(Invoice item) {
        while(true){
            try {
                System.out.println("Nhập id: ");
                item.id = sn.nextInt();
                sn.nextLine();
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập mã hóa đơn:");
                item.setCode_invoice(sn.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Nhập số tiền:");
                item.setTotal_money(sn.nextFloat());
                sn.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        list.add(item);
        System.out.println("Hóa đơn đã được thêm thành công !");
    }

    @Override
    public void update(int index, Invoice item) {
            while (true) {
                try {
                    System.out.println("Nhập mã hóa đơn mới:");
                    item.setCode_invoice(sn.nextLine());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                try {
                    System.out.println("Nhập số tiền mới:");
                    item.setTotal_money(sn.nextFloat());
                    sn.nextLine();
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    @Override
    public void delete(int index) {
                Iterator<Invoice> it = list.iterator();
                boolean found = true;
                while(it.hasNext()){
                    Invoice v = it.next();
                    if(v.id == index){
                        it.remove();
                        found = false;
                }
            }
                if(found){
                    System.out.println("Không có id để xóa !");
                }else{
                    System.out.println("Hóa đơn đã được xóa thành công !");
                }
        }


    @Override
    public void display() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("ID: "+list.get(i).id+
                    " , Mã hóa đơn: "+list.get(i).code_invoice+
                    " , Số tiền: "+list.get(i).total_money);
        }
    }
}
