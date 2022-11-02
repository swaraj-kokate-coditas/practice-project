package com.springrest.makemyevent.repositories;

import com.springrest.makemyevent.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
