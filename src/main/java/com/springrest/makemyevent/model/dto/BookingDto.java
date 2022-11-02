package com.springrest.makemyevent.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BookingDto {

    private Long bookingId;
    private Date bookingStartDate;
    private Date bookingEndDate;
    private int totalBookedSeats;
    private Long eventId;
    private Long customerId;
}
