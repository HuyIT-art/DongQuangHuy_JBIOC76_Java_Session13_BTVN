package Session13.Kha1;
import java.util.Scanner;
import java.util.LinkedList;
public class Person {
    public String name;
    public String email;
    public String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty() ){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Vui lòng không để trống !");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && !email.trim().isEmpty()){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Vui lòng không để trống !");
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone != null && !phone.trim().isEmpty()){
            this.phone = phone;
        }else{
            throw new IllegalArgumentException("Vui lòng không để trống !");
        }
    }
    public void inputData(Scanner sn){

        while(true){
            try{
                System.out.println("Nhập tên người dùng: ");
                this.setName(sn.nextLine());
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                System.out.println("Nhập email người dùng: ");
                this.setEmail(sn.nextLine());
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        while(true){
            try{
                System.out.println("Nhập phone người dùng: ");
                this.setPhone(sn.nextLine());
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

    }
    public void outputData(){
        System.out.println("Tên: "+this.name+
                ", Email: "+this.email+
                ", Số điện thoại: "+this.phone);
    }
}
