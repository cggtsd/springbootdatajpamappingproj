package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PHONE_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    
    @Id
    @GeneratedValue
    private long id;
    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="s_id")
    private Student student;

    public void assignPhoneToStudent(Student student2) {
       this.student=student2;
    }
}
