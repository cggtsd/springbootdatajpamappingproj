package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.AuthorNew;

public interface AuthorRepository  extends JpaRepository<AuthorNew,Long>{
    
}
