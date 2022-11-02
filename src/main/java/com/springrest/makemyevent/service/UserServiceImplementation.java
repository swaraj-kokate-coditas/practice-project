package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.Admin;
import com.springrest.makemyevent.entity.Customer;
import com.springrest.makemyevent.entity.EventOrganiser;
import com.springrest.makemyevent.entity.User;
import com.springrest.makemyevent.model.dto.UserDto;
import com.springrest.makemyevent.repositories.AdminRepository;
import com.springrest.makemyevent.repositories.CustomerRepository;
import com.springrest.makemyevent.repositories.EventOrganiserRepository;
import com.springrest.makemyevent.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventOrganiserRepository eventOrganiserRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public User registerUser(UserDto userDto) {

        if (userDto.getUserRole().equals("eventOrganiser")) {
            EventOrganiser eventOrganiser = new EventOrganiser();
            eventOrganiser.setEventOrganiserName(userDto.getUserName());
            eventOrganiser.setEventOrganiserNumber(userDto.getUserNumber());
            eventOrganiser.setEventOrganiserEmail(userDto.getUserEmail());
            eventOrganiserRepository.save(eventOrganiser);
        } else if (userDto.getUserRole().equals("admin")) {
            Admin admin = new Admin();
            admin.setAdminName(userDto.getUserName());
            admin.setAdminNumber(userDto.getUserNumber());
            admin.setAdminEmail(userDto.getUserEmail());
            adminRepository.save(admin);
        } else if (userDto.getUserRole().equals("customer")) {
            Customer customer = new Customer();
            customer.setCustomerName(userDto.getUserName());
            customer.setCustomerNumber(userDto.getUserNumber());
            customer.setCustomerEmail(userDto.getUserEmail());
            customerRepository.save(customer);
        }

        //to save user
        User user = new User();
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRole(userDto.getUserRole());
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity loginUser(User user) {
        User foundUser = null;
        foundUser = userRepository.findByuserEmail(user.getUserEmail());

        if (foundUser != null) {
            if (user.getUserPassword().equals(foundUser.getUserPassword())) {

                try {
                    if (foundUser.getUserRole().equals("admin")) {
                        Admin adminUser = adminRepository.findByadminEmail(user.getUserEmail());
                        return new ResponseEntity(Optional.of(adminUser), HttpStatus.OK);
                    } else if (foundUser.getUserRole().equals("eventOrganiser")) {
                        EventOrganiser eventOrganiserUser = eventOrganiserRepository.findByeventOrganiserEmail(user.getUserEmail());
                        return new ResponseEntity(Optional.of(eventOrganiserUser), HttpStatus.OK);
                    } else if (foundUser.getUserRole().equals("customer")) {
                        Customer customerUser = customerRepository.findBycustomerEmail(user.getUserEmail());
                        return new ResponseEntity(Optional.of(customerUser), HttpStatus.OK);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                    return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}


