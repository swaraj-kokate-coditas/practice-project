package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.EventCategory;
import com.springrest.makemyevent.repositories.AdminRepository;
import com.springrest.makemyevent.repositories.EventCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImplementation implements AdminService{

    @Autowired
    EventCategoryRepository eventCategoryRepository;

    @Override
    public EventCategory addEventCategory(EventCategory eventCategory) {
         return eventCategoryRepository.save(eventCategory);
    }

    @Override
    public List<EventCategory> showEventCategories() {
        return eventCategoryRepository.findAll();
    }

    @Override
    public EventCategory updateEventCategory(Long eventCategoryId, EventCategory updatedEventCategory) {
       EventCategory findEventCategory = eventCategoryRepository.findById(eventCategoryId).orElse(null);

        if(findEventCategory != null) {
            findEventCategory.setEventCategoryName(updatedEventCategory.getEventCategoryName());
            return findEventCategory;
        } else {
            return null;
        }
    }

    @Override
    public void deleteEventCategory(Long eventCategoryId) {
        eventCategoryRepository.deleteById(eventCategoryId);
    }
}
