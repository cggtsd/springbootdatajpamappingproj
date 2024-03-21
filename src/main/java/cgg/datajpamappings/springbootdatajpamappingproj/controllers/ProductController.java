package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dto.ApiResponse;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Product1;
import cgg.datajpamappings.springbootdatajpamappingproj.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
   
    private ProductService productService;

    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{offset}/{pageSize}")
    public ApiResponse<Page<Product1>> getProductsWithPaging(@PathVariable int offset,@PathVariable int pageSize){
            Page<Product1> products = this.productService.findProductsWithPaging(offset, pageSize);
            return new ApiResponse<>(products.getSize(),products);
    }
    @GetMapping("/{offset}/{pageSize}/{field}")
    public ApiResponse<Page<Product1>> getProductsWithPagingAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
            Page<Product1> products = this.productService.findProductsWithPagingAndSorting(offset, pageSize,field);
            return new ApiResponse<>(products.getSize(),products);
    }
}
