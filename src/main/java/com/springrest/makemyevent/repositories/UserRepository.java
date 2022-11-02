package com.springrest.makemyevent.repositories;

import com.springrest.makemyevent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByuserEmail(String userEmail);
    Optional<User> findByUserPassword(String userPassword);

}
