package com.TicketBookingSystem.TicketBookingProcess.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    private Long eventID;
    private String eventType;
    private String eventName;
    private String eventDescription;
    private String eventTimeDuration;


}
