package com.TicketBookingSystem.TicketBookingProcess.Controller;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.EventDTO;
import com.TicketBookingSystem.TicketBookingProcess.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getevent/{eventID}")
    public EventDTO getEvent(@PathVariable("eventID") Long eventID) {
        return eventService.getEventByEventId(eventID);
    }

    @PostMapping("addevent")
    public EventDTO addEvent(@RequestBody EventDTO eventDTO) {
        return eventService.addEvent(eventDTO);
    }

    @PutMapping("updateevent")
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(eventDTO);
    }

    @DeleteMapping("deleteevent/{eventID}")
    public String deleteEvent(@PathVariable("eventID") Long eventID) {
        return eventService.deleteEventByEventId(eventID);
    }
}
