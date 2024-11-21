package com.TicketBookingSystem.TicketBookingProcess.Controller;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.EventDTO;
import com.TicketBookingSystem.TicketBookingProcess.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/event/")
public class EventController {
    @Autowired
    private EventService eventService;

//    @GetMapping("getevents")
//    public List<EventDTO> getEvents() {
//        return eventService.getAllEvents();
//    }
}
