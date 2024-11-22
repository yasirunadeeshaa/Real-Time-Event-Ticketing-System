package com.TicketBookingSystem.TicketBookingProcess.Controller;

import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.SeatDTO;
import com.TicketBookingSystem.TicketBookingProcess.DataTransferObject.TicketDTO;
import com.TicketBookingSystem.TicketBookingProcess.Service.SeatService;
import com.TicketBookingSystem.TicketBookingProcess.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/seat/")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("getseats")
    public List<SeatDTO> getAllSeats() {
        return seatService.getAllSeats();
    }
    @GetMapping("getseat/{seatID}")
    public SeatDTO getSeatBy_SeatId(@PathVariable Long seatId) {
        return seatService.getSeatBySeatId(seatId);
    }
    @PostMapping("addseat")
    public SeatDTO addSeat(@RequestBody SeatDTO seatDTO) {
        return seatService.addseat(seatDTO);
    }
    @PutMapping("updateseat")
    public SeatDTO updateSeat(@RequestBody SeatDTO seatDTO) {
        return seatService.updateSeat(seatDTO);
    }
    @DeleteMapping("deleteseat/{seatID}")
    public String deleteSeat(@PathVariable Long seatId) {
        return seatService.deleteSeat(seatId);

    }
}