package com.springrest.makemyevent.repositories;

import com.springrest.makemyevent.entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Long> {
}
