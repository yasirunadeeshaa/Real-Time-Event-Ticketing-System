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
public class Ticket {

    @Id
    private Long ticketID;
    private int ticketNumber;
    private String ticketName;
    private String ticketType;
    private String ticketStatus;
    private double ticketPrice;


}
