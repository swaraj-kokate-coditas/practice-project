package com.springrest.makemyevent.repositories;

import com.springrest.makemyevent.entity.Admin;
import com.springrest.makemyevent.entity.EventCategory;
import com.springrest.makemyevent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByadminEmail(String adminEmail);
}
