package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.Booking;
import com.fadedink.fadedspringbootbe.entities.Client;
import com.fadedink.fadedspringbootbe.exceptions.ResourceNotFoundException;
import com.fadedink.fadedspringbootbe.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    // TODO: need endpoints where we get bookings for specific day/week
    @GetMapping("/bookings")
    public @ResponseBody Iterable<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping("/bookings")
    public @ResponseBody String addBooking(
            @RequestBody Booking newBooking)
    {
        bookingRepository.save(newBooking);
        return "Booking created successfully";
    }

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
        bookingRepository.save(updateBooking);
        return "Booking details updated";
    }
}
