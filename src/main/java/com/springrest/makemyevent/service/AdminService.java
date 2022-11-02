package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.EventCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    EventCategory addEventCategory(EventCategory eventCategory);
    List<EventCategory> showEventCategories();
    EventCategory updateEventCategory(Long eventCategoryId, EventCategory updatedEventCategory);
    void deleteEventCategory(Long eventCategoryId);
}
