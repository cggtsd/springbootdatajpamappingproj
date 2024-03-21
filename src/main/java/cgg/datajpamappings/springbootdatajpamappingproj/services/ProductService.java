package cgg.datajpamappings.springbootdatajpamappingproj.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.Product1Repository;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.Product1;
import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
    
    private Product1Repository repo;

    public ProductService(Product1Repository repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void initDB(){
       List<Product1> products= IntStream.rangeClosed(1, 200)
        .mapToObj(i->new Product1("Product"+i,new Random().nextInt(100),new Random().nextInt(500000)))
        .collect(Collectors.toList());

        this.repo.saveAll(products);
    }

    public Page<Product1> findProductsWithPaging(int offset,int pageSize){
        return this.repo.findAll(PageRequest.of(offset, pageSize));
    }
    public Page<Product1> findProductsWithPagingAndSorting(int offset,int pageSize,String field){
        return this.repo.findAll(PageRequest.of(offset,pageSize,Sort.by(Sort.Direction.ASC,field)));
    }


}
