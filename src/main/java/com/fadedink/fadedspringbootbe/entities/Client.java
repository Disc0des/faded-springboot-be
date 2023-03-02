package com.fadedink.fadedspringbootbe.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity // Tells Hibernate to make a table out of this class
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable=false)
    public String name;
    @Column(nullable=false)
    public String surname;
    @Column(nullable=false)
    public String contactNumber;
    @Column(nullable=false)
    public String tattooDescription;
    @Column(nullable=false)
    public int bookingsAttended;
    @OneToMany(mappedBy="custId")
    public Set<Booking> bookingsHistory;
    @Column(nullable=false)
    public boolean isGroupon;
    @Column(nullable=false)
    public Integer grouponBookings;
    @Column(nullable=false)
    public String notes;



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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}

