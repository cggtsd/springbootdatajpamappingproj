package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PRODUCT_TBL")
public class Product {

    @Id
    private int pid;
    private String productName;
    private int qty;
    private int price;

    @ManyToOne
    @JoinColumn(name="cp_fk")
    @JsonBackReference
    private Customer customer;

}
