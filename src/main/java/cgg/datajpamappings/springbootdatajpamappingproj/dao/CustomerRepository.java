package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cgg.datajpamappings.springbootdatajpamappingproj.dto.OrderResponse;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Customer;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Product;

public interface CustomerRepository  extends JpaRepository<Customer,Integer>{
    
    @Query("select new cgg.datajpamappings.springbootdatajpamappingproj.dto.OrderResponse(c.name,p.productName) from Customer c join c.products p")
    public List<OrderResponse> getJoinInformation();

    public List<Customer> findByProductsPrice(int price);
}
