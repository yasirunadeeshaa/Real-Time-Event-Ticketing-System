package com.TicketBookingSystem.TicketBookingProcess.Repository;

import com.TicketBookingSystem.TicketBookingProcess.Model.Ticket;
import com.TicketBookingSystem.TicketBookingProcess.Model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
        @Query(value = "SELECT * FROM venue WHERE venueid= ?1", nativeQuery = true)
        Venue getVenue_VenueID(Long venueID) ;


}
