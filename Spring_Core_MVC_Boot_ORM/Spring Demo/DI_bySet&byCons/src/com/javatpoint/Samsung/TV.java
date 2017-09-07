package com.javatpoint.Samsung;

public class TV {

    private String name;
    private int size;

    public String getName() {
        return name;
    }

    public TV() {
        super();
    }

    public TV(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return name + "  " + size;
    }
}
