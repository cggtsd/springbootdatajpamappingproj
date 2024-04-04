package cgg.datajpamappings.springbootdatajpamappingproj.dto;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.PassengerInfo;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;

    
}
