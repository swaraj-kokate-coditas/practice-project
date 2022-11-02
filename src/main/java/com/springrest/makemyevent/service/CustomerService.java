package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.Booking;
import com.springrest.makemyevent.entity.Customer;
import com.springrest.makemyevent.entity.Feedback;
import com.springrest.makemyevent.entity.User;
import com.springrest.makemyevent.model.dto.BookingDto;
import com.springrest.makemyevent.model.dto.FeedbackDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Booking addEventBooking(BookingDto bookingDto);
    void cancelEventBooking(Long bookingId);
    Customer updateCustomerDetails(Customer customer);
    User changePassword(String oldPassword, String newPassword);
    Feedback giveFeedback(FeedbackDto feedbackDto);
}
