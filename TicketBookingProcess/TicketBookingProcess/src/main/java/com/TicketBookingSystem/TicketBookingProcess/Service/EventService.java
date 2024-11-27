package com.TicketBookingSystem.TicketBookingProcess.Service;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.EventDTO;
import com.TicketBookingSystem.TicketBookingProcess.Exceptions.ResourceNotFoundException;
import com.TicketBookingSystem.TicketBookingProcess.Model.Event;
import com.TicketBookingSystem.TicketBookingProcess.Model.Venue;
import com.TicketBookingSystem.TicketBookingProcess.Repository.EventRepository;
import com.TicketBookingSystem.TicketBookingProcess.Repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VenueRepository venueRepository;

    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return modelMapper.map(events, new TypeToken<List<Event>>() {
        }.getType());
    }

    public EventDTO getEventByEventId(Long eventId) throws ResourceNotFoundException {
        Event event = eventRepository.findEventByEventID(eventId);
        if (event == null) {
            throw new ResourceNotFoundException("Event not found with id : " + eventId);
        }
        return modelMapper.map(event, EventDTO.class);
    }

    public EventDTO getEventByEventName(String eventName) {
        Event event = eventRepository.findEventByEventName(eventName);
        if (event == null) {
            throw new RuntimeException("Event not found with name: " + eventName);
        }
        return modelMapper.map(event, EventDTO.class);
    }

    public EventDTO getEventByEventType(String eventType) {
        Event event = eventRepository.findEventByEventType(eventType);
        if (event == null) {
            throw new RuntimeException("Event not found with Type: " + eventType);
        }
        return modelMapper.map(event, EventDTO.class);
    }

    public EventDTO getEventWithVenues(Long eventID) {
        Event event = eventRepository.findEventByIdWithVenues(eventID)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + eventID));
        return modelMapper.map(event, EventDTO.class);
    }

    public EventDTO addEvent(EventDTO eventDTO) {
        eventRepository.save(modelMapper.map(eventDTO, Event.class));
        return eventDTO;
    }

    public Event addEventWithVenues(EventDTO eventDTO) {
        Event event = modelMapper.map(eventDTO, Event.class);
        // Convert VenueDTOs to Venue entities
        Set<Venue> venues = eventDTO.getVenues().stream()
                .map(venueDTO -> venueRepository.findById(venueDTO.getVenueID())
                        .orElseThrow(() -> new RuntimeException("Venue not found with ID: " + venueDTO.getVenueID())))
                .collect(Collectors.toSet());
        event.setVenues(venues);
        return eventRepository.save(event);
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
