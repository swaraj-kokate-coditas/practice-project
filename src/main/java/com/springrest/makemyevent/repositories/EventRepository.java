package com.springrest.makemyevent.repositories;

import com.springrest.makemyevent.entity.Event;
import com.springrest.makemyevent.entity.EventOrganiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByEventOrganiser(EventOrganiser eventOrganiser);

}
