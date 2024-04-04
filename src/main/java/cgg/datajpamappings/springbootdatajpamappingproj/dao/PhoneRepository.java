package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
    
}
