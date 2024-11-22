package com.TicketBookingSystem.TicketBookingProcess.Repository;

import com.TicketBookingSystem.TicketBookingProcess.Model.Seat;
import com.TicketBookingSystem.TicketBookingProcess.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query(value = "SELECT * FROM seat WHERE seattid = ?1", nativeQuery = true)
    Seat getSeatBy_SeatId(Long seatID);
}