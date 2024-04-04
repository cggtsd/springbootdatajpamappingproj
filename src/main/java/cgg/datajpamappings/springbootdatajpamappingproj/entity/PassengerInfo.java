package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PASSENGER_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class PassengerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pId;
    private String name;
    private String email;
    private String source;
    private String destination;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private Date travelDate;
    private String pickUpTime;
    private String arrivalTime;
    private double fare;

}
