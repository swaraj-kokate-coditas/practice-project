package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.Event;
import com.springrest.makemyevent.entity.EventCategory;
import com.springrest.makemyevent.entity.EventOrganiser;
import com.springrest.makemyevent.model.dto.EventDto;
import com.springrest.makemyevent.repositories.EventCategoryRepository;
import com.springrest.makemyevent.repositories.EventOrganiserRepository;
import com.springrest.makemyevent.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImplementation implements EventService{

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventCategoryRepository eventCategoryRepository;

    @Autowired
    EventOrganiserRepository eventOrganiserRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public Event addEvent(EventDto eventdto) {
       Event insertEvent = new Event();

       //from EventDto
       insertEvent.setEventName(eventdto.getEventName());
       insertEvent.setEventVenue(eventdto.getEventVenue());
       insertEvent.setEventCity(eventdto.getEventCity());
       insertEvent.setEventVenueCapacity(eventdto.getEventVenueCapacity());
       insertEvent.setEventBasePrice(eventdto.getEventBasePrice());
       insertEvent.setEventPricePerPerson(eventdto.getEventPricePerPerson());

        //from Event-Category
        EventCategory foundEventCategory = eventCategoryRepository.findById(eventdto.getEventCategoryId()).orElse(null);
        insertEvent.setEventCategory(foundEventCategory);

        //from Event-Organiser
        EventOrganiser foundEventOrganiser = eventOrganiserRepository.findById(eventdto.getEventOrganiserId()).orElse(null);
        insertEvent.setEventOrganiser(foundEventOrganiser);

        //finally, save event
        return eventRepository.save(insertEvent);
    }

    @Override
    public List<Event> showEvents(Long eventOrganiserId) {
        EventOrganiser eventOrganiser = eventOrganiserRepository.findById(eventOrganiserId).orElse(null);
        List<Event> events = eventRepository.findByEventOrganiser(eventOrganiser);

        return events;
    }

    @Override
    public Event updateEvent(EventDto eventDto) {
       Event foundEvent = eventRepository.findById(eventDto.getEventId()).orElse(null);

       if(foundEvent != null) {
           foundEvent.setEventBasePrice(eventDto.getEventBasePrice());
           foundEvent.setEventCity(eventDto.getEventCity());
           foundEvent.setEventName(eventDto.getEventName());
           foundEvent.setEventPricePerPerson(eventDto.getEventPricePerPerson());
           foundEvent.setEventVenue(eventDto.getEventVenue());
           foundEvent.setEventVenueCapacity(eventDto.getEventVenueCapacity());

           return eventRepository.save(foundEvent);
       } else {
           return null;
       }
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
