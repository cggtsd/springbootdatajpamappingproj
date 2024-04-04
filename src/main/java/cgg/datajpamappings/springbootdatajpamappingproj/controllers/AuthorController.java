package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.AuthorRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.AuthorNew;

@RestController
@RequestMapping("/author")
public class AuthorController {
    
    private AuthorRepository repo;
    
    public AuthorController(AuthorRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public AuthorNew createAuthor(@RequestBody AuthorNew author){
      return this.repo.save(author);
    }

    @GetMapping
    public List<AuthorNew> getAll(){
        return repo.findAll();
    }
}
