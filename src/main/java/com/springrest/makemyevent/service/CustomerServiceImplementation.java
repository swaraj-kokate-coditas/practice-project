package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.*;
import com.springrest.makemyevent.model.dto.BookingDto;
import com.springrest.makemyevent.model.dto.FeedbackDto;
import com.springrest.makemyevent.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public Booking addEventBooking(BookingDto bookingDto) {
        Booking addBooking = new Booking();

        //from bookingDto
        addBooking.setBookingStartDate(bookingDto.getBookingStartDate());
        addBooking.setBookingEndDate(bookingDto.getBookingEndDate());
        addBooking.setTotalBookedSeats(bookingDto.getTotalBookedSeats());

        //from event
        Event event = eventRepository.findById(bookingDto.getEventId()).orElse(null);
        float bookingTotalPrice = (event.getEventBasePrice() + (event.getEventPricePerPerson() * bookingDto.getTotalBookedSeats()));
        addBooking.setBookingTotalPrice(bookingTotalPrice);
        addBooking.setEvent(event);

        //from customer
        Customer customer = customerRepository.findById(bookingDto.getCustomerId()).orElse(null);
        addBooking.setCustomer(customer);

        addBooking.setBookingStatus("pending");
        return addBooking;
    }

    @Override
    public void cancelEventBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        booking.setBookingStatus("cancelled");
        bookingRepository.save(booking);
    }

    @Override
    public Customer updateCustomerDetails(Customer customer) {
        Customer updatedCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);

        if(updatedCustomer != null) {
            updatedCustomer.setCustomerName(customer.getCustomerName());
            updatedCustomer.setCustomerNumber(customer.getCustomerNumber());
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    @Override
    public User changePassword(String oldPassword, String newPassword) {
        User user = userRepository.findByUserPassword(oldPassword).orElse(null);

        if(user != null) {
            user.setUserPassword(newPassword);
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public Feedback giveFeedback(FeedbackDto feedbackDto) {
        Feedback provideFeedback = new Feedback();

        //from feedback-dto
        provideFeedback.setFeedbackComment(feedbackDto.getFeedbackComment());
        provideFeedback.setFeedbackRating(feedbackDto.getFeedBackRating());

        Event event = eventRepository.findById(feedbackDto.getEventId()).orElse(null);
        provideFeedback.setEvent(event);

        Customer customer = customerRepository.findById(feedbackDto.getCustomerId()).orElse(null);
        provideFeedback.setCustomer(customer);

        return feedbackRepository.save(provideFeedback);
    }
}
