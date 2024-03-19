package cgg.datajpamappings.springbootdatajpamappingproj.dto;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.Customer;

public record OrderRequest(Customer customer) {
    
}
