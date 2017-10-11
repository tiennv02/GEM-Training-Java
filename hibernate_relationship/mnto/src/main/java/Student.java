public class Student {
    private int id;
    private String name;
    private Classs class_ID;

    public Student(int id, String name, Classs class_ID) {
        this.id = id;
        this.name = name;
        this.class_ID = class_ID;
    }



    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classs getClass_ID() {
        return class_ID;
    }

    public void setClass_ID(Classs class_ID) {
        this.class_ID = class_ID;
    }
}
