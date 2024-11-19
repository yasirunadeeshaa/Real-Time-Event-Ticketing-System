package com.TicketBookingSystem.TicketBookingProcess.Service;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.TicketDTO;
import com.TicketBookingSystem.TicketBookingProcess.Model.Ticket;
import com.TicketBookingSystem.TicketBookingProcess.Repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TicketDTO> getAllTickets() {
        List<Ticket> ticketList = TicketRepository.findAll();
        return modelMapper.map(ticketList, new TypeToken<List<TicketDTO>>(){}.getType());
    }

}
