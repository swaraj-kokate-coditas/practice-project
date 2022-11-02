package com.springrest.makemyevent.model.dto;

import lombok.Data;

@Data
public class EventDto {

    private Long eventId;
    private String eventName;
    private String eventVenue;
    private String eventCity;
    private int eventVenueCapacity;
    private float eventBasePrice;
    private float eventPricePerPerson;
    private Long eventCategoryId;
    private Long eventOrganiserId;

}
