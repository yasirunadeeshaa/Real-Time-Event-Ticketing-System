package com.TicketBookingSystem.TicketBookingProcess.Repository;

import com.TicketBookingSystem.TicketBookingProcess.Model.Event;
import com.TicketBookingSystem.TicketBookingProcess.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT * FROM event WHERE eventid = ?1", nativeQuery = true)
    Event getEventBy_EventId(Long eventID);
}