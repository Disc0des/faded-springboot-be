package com.fadedink.fadedspringbootbe.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
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
    @Column
    public LocalDateTime nextBooking;
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
    public String getTattooDescription() {
        return tattooDescription;
    }
    public void setTattooDescription(String tattooDescription) {
        this.tattooDescription = tattooDescription;
    }
    public int getBookingsAttended() {
        return bookingsAttended;
    }
    public void setBookingsAttended(int bookingsAttended) {
        this.bookingsAttended = bookingsAttended;
    }
    public LocalDateTime getNextBooking() {
        return nextBooking;
    }
    public void setNextBooking(LocalDateTime nextBooking) {
        this.nextBooking = nextBooking;
    }
    public boolean getIsGroupon() {
        return isGroupon;
    }
    public void setIsGroupon(boolean isGroupon) {
        this.isGroupon = isGroupon;
    }
    public int getGrouponBookings() {
        return grouponBookings;
    }
    public void setGrouponBookings(int grouponBookings) {
        this.grouponBookings = grouponBookings;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}

