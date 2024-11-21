package com.TicketBookingSystem.TicketBookingProcess.Repository;

import com.TicketBookingSystem.TicketBookingProcess.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "SELECT * FROM ticket WHERE ticketid = ?1", nativeQuery = true)
    Ticket getTicketBy_TicketId(Long ticketID);
}
