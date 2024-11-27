package com.TicketBookingSystem.TicketBookingProcess.DataTransferObject;

import com.TicketBookingSystem.TicketBookingProcess.Model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDTO {
    private Long venueID;
    private String VenueName;
    private String VenueAddress;
    private int venueCity;
    private int capacity;

    private Set<Event> events;
}
