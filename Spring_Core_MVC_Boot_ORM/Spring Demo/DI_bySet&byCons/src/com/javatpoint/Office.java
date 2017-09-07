package com.javatpoint;

public class Office {

    private int id;
    private String name;
    private String address;

    //Constructor Office
    public Office() {
    }

    //Constructor Office
    public Office(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    //Getter Setter Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //Getter Setter Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Getter Setter Address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
