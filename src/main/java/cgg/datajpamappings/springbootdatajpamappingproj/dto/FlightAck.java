package cgg.datajpamappings.springbootdatajpamappingproj.dto;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightAck {
    
    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
