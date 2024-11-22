package com.TicketBookingSystem.TicketBookingProcess.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDTO {
    private Long venueID;
    private String VenueName;
    private String VenueAddress;
    private int venueCity;
    private int capacity;
}
