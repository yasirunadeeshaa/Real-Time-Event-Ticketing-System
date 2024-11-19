package com.TicketBookingSystem.TicketBookingProcess.Controller;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.TicketDTO;
import com.TicketBookingSystem.TicketBookingProcess.Model.Ticket;
import com.TicketBookingSystem.TicketBookingProcess.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/ticket/")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("v1/gettickets")
    public List<TicketDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }
    @GetMapping("v1/getticket/{ticketId}")
    public TicketDTO getTicketBy_TicketId(@PathVariable Long ticketId) {
       return ticketService.getTicketByTicketId(ticketId);
    }
    @PostMapping("/addticket")
    public TicketDTO addTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.saveTicket(ticketDTO);
    }
    @PutMapping("/updateticket")
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO) {
        return ticketService.updateTicket(ticketDTO);
    }
    @DeleteMapping("/deleteticket/{ticketId}")
    public void deleteTicket(@PathVariable Long ticketId) {
        ticketService.deleteTicket(ticketId);
    }
}
