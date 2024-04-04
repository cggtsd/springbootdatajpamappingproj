package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.PaymentInfo;

public interface PaymentRepository  extends JpaRepository<PaymentInfo,UUID>{
    
}
    

