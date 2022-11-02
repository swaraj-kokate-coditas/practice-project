package com.springrest.makemyevent.controller;

import com.springrest.makemyevent.entity.EventCategory;
import com.springrest.makemyevent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    //to insert event-category into database
    @CrossOrigin
    @PostMapping(value = "/insertEventCategory")
    public ResponseEntity addEventCategory(@RequestBody EventCategory eventCategory) {
        try {
            return new ResponseEntity<>(Optional.of(adminService.addEventCategory(eventCategory)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get the list of event-categories
    @CrossOrigin
    @GetMapping("/getEventCategories")
    public ResponseEntity<List<EventCategory>> getEventCategories() {
        try {
            List<EventCategory> eventCategoryList = adminService.showEventCategories();

            if(eventCategoryList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(eventCategoryList, HttpStatus.OK);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update existing event-category name
    @CrossOrigin
    @PutMapping(value = "/updateEventCategory/{eventCategoryId}")
    public ResponseEntity updateEventCategory(@PathVariable Long eventCategoryId, @RequestBody EventCategory eventCategory) {
        try {
            EventCategory updatedEventCategory = adminService.updateEventCategory(eventCategoryId, eventCategory);

            if(updatedEventCategory != null) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete existing student record
    @CrossOrigin
    @DeleteMapping(value = "/deleteEventCategory/{eventCategoryId}")
    public ResponseEntity deleteEventCategory(@PathVariable Long eventCategoryId) {
        try {
            adminService.deleteEventCategory(eventCategoryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
