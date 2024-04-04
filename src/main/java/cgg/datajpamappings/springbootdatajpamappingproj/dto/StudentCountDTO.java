package cgg.datajpamappings.springbootdatajpamappingproj.dto;

public record StudentCountDTO(int age,long count) {
    
    public StudentCountDTO(int count){
        this(0,count);
    }
}
