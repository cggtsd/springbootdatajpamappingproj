package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dto.FlightAck;
import cgg.datajpamappings.springbootdatajpamappingproj.dto.FlightRequest;
import cgg.datajpamappings.springbootdatajpamappingproj.services.BookFilghtTicketService;

@RestController
public class FlightController {
    
    private BookFilghtTicketService flightService;

    public FlightController(BookFilghtTicketService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/bookFlightTicket")
    public FlightAck bookTicket(@RequestBody FlightRequest flightRequest){
        return this.flightService.bookFlightTicket(flightRequest);
    }
    @PutMapping("/bookFlightTicket/{id}")
    public FlightAck updateTicket(@PathVariable long id,@RequestBody FlightRequest flightRequest){
        return this.flightService.updateFlightTicket(flightRequest,id);
    }
}
