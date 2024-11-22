package com.TicketBookingSystem.TicketBookingProcess.Service;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.EventDTO;
import com.TicketBookingSystem.TicketBookingProcess.Model.Event;
import com.TicketBookingSystem.TicketBookingProcess.Repository.EventRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return modelMapper.map(events, new TypeToken<List<Event>>() {}.getType());
    }
    public EventDTO getEventByEventId(Long eventId) {
        Event event = eventRepository.getEventBy_EventId(eventId);
        return modelMapper.map(event, EventDTO.class);
    }
    public EventDTO addEvent(EventDTO eventDTO) {
        eventRepository.save(modelMapper.map(eventDTO, Event.class));
        return eventDTO;
    }
    public EventDTO updateEvent(EventDTO eventDTO) {
        eventRepository.save(modelMapper.map(eventDTO, Event.class));
        return eventDTO;
    }
    public String deleteEventByEventId(Long eventID) {
        eventRepository.deleteById(eventID);
        return " EVENT DELETED";
    }
}
