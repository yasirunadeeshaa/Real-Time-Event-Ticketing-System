package com.TicketBookingSystem.TicketBookingProcess.DataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private Long seatID;
    private int seatNumber;
    private String seatType;
}
