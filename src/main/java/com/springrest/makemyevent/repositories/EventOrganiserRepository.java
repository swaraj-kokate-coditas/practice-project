package com.springrest.makemyevent.repositories;

import com.springrest.makemyevent.entity.Admin;
import com.springrest.makemyevent.entity.EventOrganiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventOrganiserRepository extends JpaRepository<EventOrganiser, Long> {

    EventOrganiser findByeventOrganiserEmail(String eventorganiserEmail);
}
