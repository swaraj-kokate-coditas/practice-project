package com.springrest.makemyevent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "Booking_Details")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long bookingId;
    private Date bookingStartDate;
    private Date bookingEndDate;
    private float bookingTotalPrice;
    private int totalBookedSeats;
    private String bookingStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
