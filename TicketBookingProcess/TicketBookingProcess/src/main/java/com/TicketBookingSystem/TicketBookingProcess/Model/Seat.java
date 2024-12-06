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
public class Seat {
    @Id
    private Long seatID;
    private int seatNumber;
    private String seatType;
}
