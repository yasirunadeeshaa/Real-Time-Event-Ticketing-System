package com.TicketBookingSystem.TicketBookingProcess.Controller;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.VenueDTO;
import com.TicketBookingSystem.TicketBookingProcess.Model.Venue;
import com.TicketBookingSystem.TicketBookingProcess.Repository.VenueRepository;
import com.TicketBookingSystem.TicketBookingProcess.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/venue/")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @GetMapping("getVenues")
    public List<VenueDTO> getAllVenues(){
        return venueService.getAllVenues();
    }

    @GetMapping("getVenue/{venueID}")
    public VenueDTO getVenueById(@PathVariable("venueID") Long venueID){
        return venueService.getVenueByVenueId(venueID);
    }
//
//    @PostMapping("addvenue")
//    public VenueDTO addVenue(@RequestBody VenueDTO venueDTO){
//        return venueService.addVenue(venueDTO);
//    }

    @PostMapping("addVenue")
    public ResponseEntity<Venue> addVenue(@RequestBody Venue venue) {
        Venue venuesSave = venueService.addVenue(venue);
        return ResponseEntity.ok(venuesSave);
    }

    @PutMapping("updateVenue")
    public VenueDTO updateVenue(@RequestBody VenueDTO venueDTO){
        return venueService.updateVenue(venueDTO);
    }

    @DeleteMapping("deletevenue")
    public String deleteVenue(@PathVariable Long venueID){
        return venueService.deleteVenue(venueID);
    }
}
