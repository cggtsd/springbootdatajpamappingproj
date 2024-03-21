package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product1 {
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int qty;
    private int price;
    
    public Product1(String name, int qty, int price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    
}
