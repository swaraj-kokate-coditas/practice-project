package com.springrest.makemyevent.controller;

import com.springrest.makemyevent.entity.Event;
import com.springrest.makemyevent.model.dto.BookingDto;
import com.springrest.makemyevent.model.dto.EventDto;
import com.springrest.makemyevent.service.BookingService;
import com.springrest.makemyevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventOrganiser")
public class EventOrganiserController {

    @Autowired
    EventService eventService;

    @Autowired
    BookingService bookingService;

    //to insert events into database
    @CrossOrigin
    @PostMapping(value = "/insertEvent")
    public ResponseEntity addEvent(@RequestBody EventDto eventdto) {
        try {
            return new ResponseEntity<>(Optional.of(eventService.addEvent(eventdto)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get the list of events
    @CrossOrigin
    @GetMapping("/getEvents/{eventOrganiserId}")
    public ResponseEntity<List<Event>> getEvents(@PathVariable Long eventOrganiserId) {
        try {
            List<Event> events = eventService.showEvents(eventOrganiserId);

            if(events.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(events, HttpStatus.OK);
            }
        } catch (Exception exception) {
            System.out.println(exception);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PutMapping("/updateBooking/{bookingStatus}/{bookingId}")
    public ResponseEntity acceptOrDeclineEventBooking(@PathVariable String bookingStatus, @PathVariable Long bookingId) {
        try {
            return new ResponseEntity<>(Optional.of(bookingService.acceptOrDeclineEventBooking(bookingId, bookingStatus)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @PutMapping("/postponeBooking/")
    public ResponseEntity postPoneEventBooking(@RequestBody BookingDto bookingDto) {
        try {
            return new ResponseEntity<>(Optional.of(bookingService.postponeEventBooking(bookingDto)), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
