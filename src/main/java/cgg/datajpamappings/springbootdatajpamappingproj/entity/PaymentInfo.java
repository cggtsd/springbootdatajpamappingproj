package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import java.util.UUID;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PAYMENT_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class PaymentInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID paymentId;
    private String accountNo;
    private double amount;
    private String cardType;
    private long passengerId;
}
