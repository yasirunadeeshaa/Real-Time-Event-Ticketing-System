package com.TicketBookingSystem.TicketBookingProcess.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueID;

    private String VenueName;
    private String VenueAddress;
    private int venueCity;
    private int capacity;

    @ManyToMany(mappedBy = "venues", fetch = FetchType.EAGER)
    private List<Event> events;// = new HashSet<>();
//    //private List<Ticket> tickets;
}
