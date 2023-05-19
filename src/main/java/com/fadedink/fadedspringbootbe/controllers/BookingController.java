package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.Booking;
import com.fadedink.fadedspringbootbe.exceptions.ResourceNotFoundException;
import com.fadedink.fadedspringbootbe.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    // TODO: need endpoints where we get bookings for specific day/week
    @GetMapping("/bookings-history/{id}")
    public @ResponseBody List<Booking> getBookingHistory(@PathVariable int id) {
        List<Booking> bookingsHistory = bookingRepository.getBookingHistory(id);
        return bookingsHistory;
    }

    @GetMapping("/next-booking/{id}")
    public @ResponseBody Booking getNextBooking(@PathVariable int id) {
       Booking nextBooking = bookingRepository.getNextBooking(id);
       return nextBooking;
    }

    @GetMapping("/bookings")
    public @ResponseBody Iterable<Booking> getBookings() {
        Iterable<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    @PostMapping("/bookings")
    public @ResponseBody String addBooking(
            @RequestBody Booking newBooking)
    {
        bookingRepository.save(newBooking);
        return "Booking created successfully";
    }

    // TODO: soft deletes
    @DeleteMapping("/bookings")
    public @ResponseBody String removeBooking(@RequestBody Booking booking)
    {
        bookingRepository.deleteById(booking.id);
        return "Booking removed successfully";
    }

    @PutMapping("/bookings")
    public @ResponseBody String updateBooking(
            @RequestBody Booking booking) {
        Booking updateBooking = bookingRepository.findById(booking.id).orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id: " + booking.id));;
        updateBooking.setCustId(booking.custId);
        updateBooking.setDate(booking.date);
        updateBooking.setConfirmed(booking.confirmed);
        updateBooking.setAttended(booking.attended);
        updateBooking.setIsGroupon(booking.isGroupon);
        updateBooking.setPrice(booking.price);
        updateBooking.setDuration(booking.duration);
        updateBooking.setBookingName(booking.bookingName);
        updateBooking.setBookingSurname(booking.bookingSurname);
        bookingRepository.save(updateBooking);
        return "Booking details updated";
    }
}
