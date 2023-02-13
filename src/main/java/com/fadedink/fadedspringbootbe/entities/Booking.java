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
    public String confirmed;
    @Column(nullable=false)
    public String attended;
    @Column(nullable=false)
    public String isGroupon;
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

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getAttended() {
        return attended;
    }

    public void setAttended(String attended) {
        this.attended = attended;
    }

    public String getIsGroupon() {
        return isGroupon;
    }

    public void setIsGroupon(String isGroupon) {
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
