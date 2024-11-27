package com.TicketBookingSystem.TicketBookingProcess.DataTransferObject;

import com.TicketBookingSystem.TicketBookingProcess.Model.Venue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long eventID;
    private String eventType;
    private String eventName;
    private String eventDescription;
    private String eventTimeDuration;

    private List<Venue> venues;
}
