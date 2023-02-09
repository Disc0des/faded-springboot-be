package com.fadedink.fadedspringbootbe.repositories;

import com.fadedink.fadedspringbootbe.entities.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer>  {
}