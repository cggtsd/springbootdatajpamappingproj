package cgg.datajpamappings.springbootdatajpamappingproj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="AUTHOR_TBL")
@SecondaryTable(name="AUTHOR_DETAILS_TBL",pkJoinColumns = @PrimaryKeyJoinColumn(name="authorId",referencedColumnName = "id"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorNew {
  
    @Id
    @GeneratedValue
    @Column(updatable = false,nullable = false)
    private long id;

    @Version
    private int version;

    private String firstName;
    private String lastName;
    

    @Column(table = "AUTHOR_DETAILS_TBL")
    private String category;

    @Column(table = "AUTHOR_DETAILS_TBL")
    private String email;



}
