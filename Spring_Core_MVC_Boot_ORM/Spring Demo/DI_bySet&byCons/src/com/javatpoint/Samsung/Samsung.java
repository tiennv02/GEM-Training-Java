package com.javatpoint.Samsung;

public class Samsung {
    private String Address;
    private Mobile mb;
    private TV tv;

    public Samsung() {
        super();
    }


    public Samsung(String address, Mobile mb, TV tv) {
        Address = address;
        this.mb = mb;
        this.tv = tv;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Mobile getMb() {
        return mb;
    }

    public void setMb(Mobile mb) {
        this.mb = mb;
    }

    public TV getTv() {
        return tv;
    }

    public void setTv(TV tv) {
        this.tv = tv;
    }
}
