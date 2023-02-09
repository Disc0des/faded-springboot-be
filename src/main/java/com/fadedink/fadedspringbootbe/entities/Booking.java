package com.fadedink.fadedspringbootbe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer id;
    public Integer custId;
    public Date date;
    public String confirmed;
    public String attended;
    public String isGroupon;
    public Integer price;
    public Integer time;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
