package com.springrest.makemyevent.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Event_Category_Details")
public class EventCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long eventCategoryId;
    private String eventCategoryName;

    @OneToMany(mappedBy = "eventCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();


}
