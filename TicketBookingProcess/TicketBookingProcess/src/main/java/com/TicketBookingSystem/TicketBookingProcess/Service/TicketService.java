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
        List<Ticket> ticketList = ticketRepository.findAll();
        return modelMapper.map(ticketList, new TypeToken<List<TicketDTO>>(){}.getType());
    }
    public TicketDTO getTicketByTicketId(Long ticketID) {

        //ticketRepository.deleteById(ticketID);
        //return modelMapper.map(ticketRepository.findById(ticketID).get(), TicketDTO.class);
        Ticket ticket = ticketRepository.getTicketBy_TicketId(ticketID);
        return modelMapper.map(ticket, TicketDTO.class);
//        if (ticket == null) {throw new RuntimeException("Product not found with ID: " + ticketId);}
//        else {return modelMapper.map(ticket, TicketDTO.class);}
    }
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        ticketRepository.save(modelMapper.map(ticketDTO, Ticket.class));
        return ticketDTO;
    }
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        ticketRepository.save(modelMapper.map(ticketDTO, Ticket.class));
        return ticketDTO;

    }
    public String deleteTicket(Long ticketID) {
        ticketRepository.deleteById(ticketID);
        return "Ticket deleted";
    }

}




