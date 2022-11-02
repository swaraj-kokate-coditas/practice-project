package com.springrest.makemyevent.repositories;

import com.springrest.makemyevent.entity.Admin;
import com.springrest.makemyevent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findBycustomerEmail(String customerEmail);
}
