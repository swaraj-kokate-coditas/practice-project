package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.Event;
import com.springrest.makemyevent.model.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {

    Event addEvent(EventDto eventdto);

   List<Event> showEvents(Long eventOrganiserId);
    Event updateEvent(EventDto eventDto);
    void deleteEvent(Long eventId);
}
