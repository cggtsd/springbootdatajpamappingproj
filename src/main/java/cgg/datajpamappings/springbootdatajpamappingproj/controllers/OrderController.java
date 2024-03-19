package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.CustomerRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.dao.ProductRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.dto.OrderRequest;
import cgg.datajpamappings.springbootdatajpamappingproj.dto.OrderResponse;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Customer;

@RestController
public class OrderController {
    
    private CustomerRepository customerRepository;

    private ProductRepository productRepository;

    public OrderController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/placeOrders")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        return customerRepository.save(orderRequest.customer());
    }

    @GetMapping("/findallorders")
    public List<Customer> getAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getjoininfo")
    public List<OrderResponse> getJoinInfo(){
      return customerRepository.getJoinInformation();
    }
}
