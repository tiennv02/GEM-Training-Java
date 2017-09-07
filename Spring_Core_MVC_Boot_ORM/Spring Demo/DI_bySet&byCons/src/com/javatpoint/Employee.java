package com.javatpoint;

public class Employee {
    private int id;
    private String name;
    private String city;
    private String phone;

    //Constuctor Employee
    public Employee() {}

    //Constructor Employee
    public Employee(int id, String name, String city, String phone) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.phone = phone;
}

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String name) {
        this.name = name;
    }

    //Getter Setter Phone
    public String getPhone() {
            return phone;
        }
    public void setPhone(String phone) {
            this.phone = phone;
        }

    //Getter Setter	Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //Getter Setter Name
    public String  getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Getter Setter City
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    void display(){
        System.out.println(id+" "+name+" "+city);
    }
}
