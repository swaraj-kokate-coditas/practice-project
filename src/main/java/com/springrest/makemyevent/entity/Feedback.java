package com.springrest.makemyevent.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Feedback_Details")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long feedbackId;
    @Lob
    private String feedbackComment;
    private float feedbackRating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
