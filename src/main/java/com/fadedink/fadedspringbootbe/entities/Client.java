package com.fadedink.fadedspringbootbe.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
    @Column(nullable = false)
    public LocalDate lastContacted;
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
    public LocalDate getLastContacted() {
        return lastContacted;
    }
    public void setLastContacted(LocalDate lastContacted) {
        this.lastContacted = lastContacted;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}

