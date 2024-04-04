package cgg.datajpamappings.springbootdatajpamappingproj.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.PassengerRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.dao.PaymentRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.dto.FlightAck;
import cgg.datajpamappings.springbootdatajpamappingproj.dto.FlightRequest;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.PassengerInfo;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.PaymentInfo;
import cgg.datajpamappings.springbootdatajpamappingproj.utils.PaymentUtils;
import jakarta.transaction.Transactional;

@Service
public class BookFilghtTicketService {
    
    private PassengerRepository passengerRepository;

    private PaymentRepository paymentRepository;

    public BookFilghtTicketService(PassengerRepository passengerRepository, PaymentRepository paymentRepository) {
        this.passengerRepository = passengerRepository;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public FlightAck bookFlightTicket(FlightRequest flightRequest){
        
        PassengerInfo passengerInfo = flightRequest.getPassengerInfo();
        passengerRepository.save(passengerInfo);

        PaymentInfo paymentInfo = flightRequest.getPaymentInfo();

        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getPId());

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());
        paymentRepository.save(paymentInfo);

        return new FlightAck("SUCCESS",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }
    @Transactional
    public FlightAck updateFlightTicket(FlightRequest flightRequest,long id){
        
         PassengerInfo p = passengerRepository.findById(id).get();

         p.setName(flightRequest.getPassengerInfo().getName());
         p.setEmail(flightRequest.getPassengerInfo().getEmail());
         
       
        passengerRepository.save(p);

        

        return new FlightAck("SUCCESS",p.getFare(),UUID.randomUUID().toString().split("-")[0],p);

    }


}
