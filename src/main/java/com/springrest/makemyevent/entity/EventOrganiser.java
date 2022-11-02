package com.springrest.makemyevent.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Event_Organiser_Details")
public class EventOrganiser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long eventOrganiserId;
    private String eventOrganiserName;
    private String eventOrganiserEmail;
    private long eventOrganiserNumber;
    private String role;

    @OneToMany(mappedBy = "eventOrganiser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>();


}
