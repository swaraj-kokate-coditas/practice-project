package com.springrest.makemyevent.service;

import com.springrest.makemyevent.entity.User;
import com.springrest.makemyevent.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService{

    User registerUser(UserDto userDto);
    ResponseEntity loginUser(User user);

}
