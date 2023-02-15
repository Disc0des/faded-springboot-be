package com.fadedink.fadedspringbootbe.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable=false)
    public int custId;
    @Column(nullable=false)
    public LocalDateTime date;
    @Column(nullable=false)
    public boolean confirmed;
    @Column(nullable=false)
    public boolean attended;
    @Column(nullable=false)
    public boolean isGroupon;
    @Column(nullable=false)
    public Integer price;
    @Column(nullable=false)
    public Integer duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean getAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }

    public boolean getIsGroupon() {
        return isGroupon;
    }

    public void setIsGroupon(boolean isGroupon) {
        this.isGroupon = isGroupon;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
