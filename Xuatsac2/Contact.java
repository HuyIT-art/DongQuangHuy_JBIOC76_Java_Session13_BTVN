package Session13.Xuatsac2;
import java.util.Set;
import java.util.Objects;
import java.util.Scanner;
import java.util.*;
public class Contact {
    private static int autoId = 0;

    private int id;
    private String name;
    private String phoneNumber;

    public Contact() {}

    public Contact(String name, String phoneNumber) {
        this.id = ++autoId;
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty() && name.length() >= 3) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Tên phải từ 3 ký tự trở lên!");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.trim().isEmpty() && phoneNumber.matches("^09\\d{8}$")) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("SĐT phải dạng 09xxxxxxxx!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            System.out.println("Số điện thoại đã tồn tại!");
            return true;
        }
        if (!(o instanceof Contact)) return false;
        Contact c = (Contact) o;
        if (phoneNumber.equals(c.phoneNumber)) {
            System.out.println("Số điện thoại đã tồn tại!");
            return phoneNumber.equals(c.phoneNumber);
        }
        return phoneNumber.equals(c.phoneNumber);
    }

    @Override
    public int hashCode(){
        return phoneNumber.hashCode();
    }
    Set<Contact> set = new HashSet<>();
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    public void inputData(Scanner sn) {
        this.id = ++autoId;

        while (true) {
            try {
                System.out.print("Nhập tên: ");
                setName(sn.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Nhập SĐT: ");
                setPhoneNumber(sn.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        set.add(this);
    }
}