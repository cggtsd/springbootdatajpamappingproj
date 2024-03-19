package cgg.datajpamappings.springbootdatajpamappingproj.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public record OrderResponse(String name,String productName,int price) {
    
    public OrderResponse(String name,String productName){
        this(name,productName,0);
    }
}
