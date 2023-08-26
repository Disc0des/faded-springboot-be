package com.fadedink.fadedspringbootbe.repositories;

import com.fadedink.fadedspringbootbe.entities.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer>  {
    @Query(value = "SELECT id, cust_id, attended, confirmed, date, duration, is_groupon, price, booking_name, booking_surname FROM booking WHERE cust_id = ?1 AND DATE(date) < DATE(SYSDATE()) ORDER BY date desc ", nativeQuery = true)
    List<Booking> getBookingHistory(Integer custId);

    @Query(value = "SELECT id, cust_id, attended, confirmed, date, duration, is_groupon, price, booking_name, booking_surname FROM booking WHERE cust_id = ?1 AND DATE(date) >= DATE(SYSDATE())", nativeQuery = true)
    Booking getNextBooking(Integer custId);

    @Query(value= "UPDATE client SET groupon_bookings += 1 WHERE client.id = ?1", nativeQuery = true)
    void increaseGrouponBookings(Integer custId);

    @Query(value= "UPDATE client SET groupon_bookings -= 1 WHERE client.id = ?1", nativeQuery = true)
    void decreaseGrouponBookings(Integer custId);
}