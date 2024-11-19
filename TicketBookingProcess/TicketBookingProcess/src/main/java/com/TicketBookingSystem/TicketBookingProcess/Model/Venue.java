package com.TicketBookingSystem.TicketBookingProcess.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    @Id
    private Long venueID;
    private String VenueName;
    private String VenueAddress;
    private int venueCity;
    private int capacity;


}
