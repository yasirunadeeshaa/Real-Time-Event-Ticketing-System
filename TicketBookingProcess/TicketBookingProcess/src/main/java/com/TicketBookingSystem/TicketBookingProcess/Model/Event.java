package com.TicketBookingSystem.TicketBookingProcess.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;

    private String eventType;
    private String eventName;
    private String eventDescription;
    private String eventTimeDuration;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "event_venue",
            joinColumns = @JoinColumn(name = "eventid"),
            inverseJoinColumns = @JoinColumn(name="venueid")
    )

    private Set<Venue> venues;// = new HashSet<>();
}