package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.entities.Booking;
import com.fadedink.fadedspringbootbe.entities.Client;
import com.fadedink.fadedspringbootbe.exceptions.ResourceNotFoundException;
import com.fadedink.fadedspringbootbe.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @GetMapping("/bookings")
    public @ResponseBody Iterable<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @PostMapping("/bookings")
    public @ResponseBody String addBooking(
            @RequestParam int custId,
            @RequestParam Date date,
            @RequestParam String confirmed,
            @RequestParam String attended,
            @RequestParam String isGroupon,
            @RequestParam int price,
            @RequestParam int duration)
    {
        Booking newBooking = new Booking();
        newBooking.setCustId(custId);
        newBooking.setDate(date);
        newBooking.setConfirmed(confirmed);
        newBooking.setAttended(attended);
        newBooking.setIsGroupon(isGroupon);
        newBooking.setPrice(price);
        newBooking.setDuration(duration);
        bookingRepository.save(newBooking);
        return "Booking created successfully";
    }

    @DeleteMapping("/bookings")
    public @ResponseBody String removeBooking(@RequestParam int id)
    {
        bookingRepository.deleteById(id);
        return "Client removed successfully";
    }

    @PutMapping("/bookings")
    public @ResponseBody String updateBooking(
            @RequestParam int id,
            @RequestParam int custId,
            @RequestParam Date date,
            @RequestParam String confirmed,
            @RequestParam String attended,
            @RequestParam String isGroupon,
            @RequestParam int price,
            @RequestParam int duration) {
        Booking updateBooking = bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id: " + id));;
        updateBooking.setCustId(custId);
        updateBooking.setDate(date);
        updateBooking.setConfirmed(confirmed);
        updateBooking.setAttended(attended);
        updateBooking.setIsGroupon(isGroupon);
        updateBooking.setPrice(price);
        updateBooking.setDuration(duration);
        bookingRepository.save(updateBooking);
        return "Booking details updated";
    }
}
