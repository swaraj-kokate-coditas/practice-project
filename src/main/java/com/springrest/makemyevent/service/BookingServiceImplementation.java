package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.Booking;
import com.springrest.makemyevent.model.dto.BookingDto;
import com.springrest.makemyevent.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.util.Date;

public class BookingServiceImplementation implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking acceptOrDeclineEventBooking(Long bookingId, String bookingStatus) {
        Booking foundBooking = bookingRepository.findById(bookingId).orElse(null);

        if(foundBooking != null) {
            if(bookingStatus.equalsIgnoreCase("accepted")) {
                foundBooking.setBookingStatus("accepted");
                return bookingRepository.save(foundBooking);
            } else {
                foundBooking.setBookingStatus("declined");
                return bookingRepository.save(foundBooking);
            }
        } else {
            return null;
        }
    }

    @Override
    public Booking postponeEventBooking(BookingDto bookingDto) {
        Booking foundBooking = bookingRepository.findById(bookingId).orElse(null);

        if(foundBooking != null) {
            foundBooking.setBookingStatus("pending");
            foundBooking.setBookingStartDate((java.sql.Date) startDate);
            foundBooking.setBookingEndDate((java.sql.Date) endDate);
            return bookingRepository.save(foundBooking);
        } else {
            return null;
        }
    }
}
