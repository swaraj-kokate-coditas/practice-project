package com.springrest.makemyevent.model.dto;

import lombok.Data;

@Data
public class FeedbackDto {

    private String feedbackComment;
    private float feedBackRating;
    private Long eventId;
    private Long customerId;
}
