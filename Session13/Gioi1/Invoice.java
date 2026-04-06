package Session13.Gioi1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Invoice {
    protected int id;
    protected String code_invoice;
    protected float total_money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }else{
            throw new IllegalArgumentException("ID phải > 0 !");
        }
    }

    public String getCode_invoice() {
        return code_invoice;
    }

    public void setCode_invoice(String code_invoice) {
        if(!code_invoice.trim().isEmpty() && code_invoice.matches("^H\\d{3}$")){
            this.code_invoice = code_invoice;
        }else{
            throw new IllegalArgumentException("Hóa đơn phải có dạng H001 ");
        }
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        if(total_money > 0){
            this.total_money = total_money;
        }else{
            throw new IllegalArgumentException("Vui lòng nhập số thực >=0 !");
        }
    }
}
