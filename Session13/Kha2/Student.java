package Session13.Kha2;
interface Manage<T>{
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}
public class Student {
    protected int id;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Vui lòng không để trống !");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0){
            this.id = id;
        }else{
            throw new IllegalArgumentException("ID không được âm !");
        }
    }
}
