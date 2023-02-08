package com.fadedink.fadedspringbootbe;

public class Contact {
    public int id;
    public String name;
    public String surname;
    public String contactNumber;
    public Contact(int i, String n, String p, String a){
        this.id = i;
        this.name = n;
        this.surname = p;
        this.contactNumber = a;
    }
}
