package com.TicketBookingSystem.TicketBookingProcess.Service;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.VenueDTO;
import com.TicketBookingSystem.TicketBookingProcess.Model.Venue;
import com.TicketBookingSystem.TicketBookingProcess.Repository.VenueRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<VenueDTO> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return modelMapper.map(venues,new TypeToken<List<VenueDTO>>(){}.getType());
    }
    public VenueDTO getVenueByVenueId(Long id) {
        Venue venue = venueRepository.getVenue_VenueID(id);
        return modelMapper.map(venue,VenueDTO.class);
    }
    public VenueDTO addVenue(VenueDTO venueDTO) {
        venueRepository.save(modelMapper.map(venueDTO,Venue.class));
        return venueDTO;
    }
    public VenueDTO updateVenue(VenueDTO venueDTO) {
        venueRepository.save(modelMapper.map(venueDTO,Venue.class));
        return venueDTO;
    }
    public String deleteVenue(Long venueid) {
        venueRepository.getVenue_VenueID(venueid);
        return "ticket" + venueid+ "deleted";
    }
}
