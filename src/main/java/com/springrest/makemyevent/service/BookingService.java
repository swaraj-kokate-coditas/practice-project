package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.Booking;
import com.springrest.makemyevent.model.dto.BookingDto;

import javax.xml.crypto.Data;
import java.sql.Date;

public interface BookingService {

    Booking acceptOrDeclineEventBooking(Long bookingId, String bookingStatus);
    Booking postponeEventBooking(BookingDto bookingDto);

}
