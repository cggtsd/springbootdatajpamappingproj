package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.PassengerInfo;

public interface PassengerRepository extends JpaRepository<PassengerInfo,Long> {
    
}
