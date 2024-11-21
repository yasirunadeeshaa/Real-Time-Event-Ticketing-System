package com.TicketBookingSystem.TicketBookingProcess.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long eventID;
    private String eventType;
    private String eventName;
    private String eventDescription;
    private String eventTimeDuration;
}
