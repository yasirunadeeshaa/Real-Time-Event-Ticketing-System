package com.TicketBookingSystem.TicketBookingProcess.Controller;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.EventDTO;
import com.TicketBookingSystem.TicketBookingProcess.Exceptions.ResourceNotFoundException;
import com.TicketBookingSystem.TicketBookingProcess.Model.Event;
import com.TicketBookingSystem.TicketBookingProcess.Service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value="api/event/")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("getevents")
    public List<EventDTO> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("{eventID}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable("eventID") Long eventID) throws ResourceNotFoundException {
        log.info("EventID: " + eventID);
        EventDTO eventDTO = eventService.getEventByEventId(eventID);
        return ResponseEntity.ok(eventDTO);
    }

    @GetMapping("getevent/name/{eventName}")
    public ResponseEntity<EventDTO> getEventByName(@PathVariable("eventName") String eventName) {
        EventDTO eventDTO = eventService.getEventByEventName(eventName);
        return ResponseEntity.ok(eventDTO);
    }

    @GetMapping("getevent/type/{eventType}")
    public ResponseEntity<EventDTO> getEventByType(@PathVariable("eventType") String eventType) {
        EventDTO eventDTO = eventService.getEventByEventType(eventType);
        return ResponseEntity.ok(eventDTO);
    }

    @GetMapping("geteventwithvenues/{eventID}")
    public ResponseEntity<EventDTO> getEventByIdWithVenues(@PathVariable Long eventID) {
        EventDTO eventDTO = eventService.getEventWithVenues(eventID);
        return ResponseEntity.ok(eventDTO);
    }

//    @GetMapping("{eventID}/venues")
//    public ResponseEntity<Set<Venue>> getVenuesForEvent(@PathVariable("eventID") Long eventID) {
//        log.info("EventID: " + eventID);
//        Set<Venue> venues = eventService.getVenuesForEvent(eventID);
////        if (venues.isEmpty()) {
////            return ResponseEntity.notFound().build();
////        }
//        return ResponseEntity.ok(venues);
//    }

//    @PostMapping("addevent")
//    public EventDTO addEvent(@RequestBody EventDTO eventDTO) throws ResourceNotFoundException {
//        log.info("EventDTO: " + eventDTO);
//        return eventService.addEvent(eventDTO);
//    }
    @PostMapping("addevents")
    public ResponseEntity<Event> addEventWithVenues(@RequestBody EventDTO eventDTO) {
        Event event = eventService.addEventWithVenues(eventDTO);
        return ResponseEntity.ok(event);
    }

    @PutMapping("updateevent")
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(eventDTO);
    }

    @DeleteMapping("deleteevent/{eventID}")
    public String deleteEvent(@PathVariable("eventID") Long eventID) {
        return eventService.deleteEventByEventId(eventID);
    }

    //ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
//    @PostMapping("addeventt")
//    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
//        Event savedEvent = eventRepository.save(event);
//        return ResponseEntity.ok(savedEvent);}
//    @PutMapping("/{eventId}/addVenue/{venueId}")
//    public ResponseEntity<Event> addVenueToEvent(@PathVariable Long eventId, @PathVariable Long venueId) {
//        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
//        Venue venue = venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found"));
//        event.getVenues().add(venue);
//        Event updatedEvent = eventRepository.save(event);
//        return ResponseEntity.ok(updatedEvent);
//    }

}
