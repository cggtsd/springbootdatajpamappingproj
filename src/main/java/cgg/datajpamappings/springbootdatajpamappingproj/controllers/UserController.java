package cgg.datajpamappings.springbootdatajpamappingproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.User;
import cgg.datajpamappings.springbootdatajpamappingproj.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{profession}")
    public List<User> getUsersByProfession(@PathVariable String profession){
        
        return this.userService.getUsersByProfession(profession);
    }

    @GetMapping("/countUsers/{age}")
    public String getCount(@PathVariable int age){
        long userCount = this.userService.getUserCount(age);
        return "Total no of records : "+userCount;
    }
    
    @GetMapping("/totalCount")
    public String getAllCount(){
        long totalCount = this.userService.getTotalCount();
        return "Total Records : "+totalCount;
    }

    @DeleteMapping("/deleteUser/{name}")
    public List<User> deleteUser(@PathVariable String name){
        return this.userService.deleteUserByName(name);
    }

    @GetMapping("/getUserByProfAndAge/{profession}/{age}")
    public List<User> getUserByProfessionAndAge(@PathVariable String profession,@PathVariable int age){
        return this.userService.findUserByProfessionAndAge(profession, age);
    }
    @GetMapping("/getUserByProfAndAgeIgnorecase/{profession}/{age}")
    public List<User> getUserByProfessionAndAgeIgnorecase(@PathVariable String profession,@PathVariable int age){
        return this.userService.findUserByProfessionAndAgeIgnoreCase(profession, age);
    }
    @GetMapping("/getUserSorted/{age}")
    public List<User> getUserSorted(@PathVariable int age){
        return this.userService.findByAgeSortedOnName(age);
    }
    @GetMapping("/getUsersSorted/{field}")
    public List<User> getUsersSorted(@PathVariable String field){
        return this.userService.findUsersWithSorting(field);
    }

    @GetMapping("/getFewusers/{age}")
    public List<User> getFewUsers(@PathVariable int age){
        return this.userService.findFirstUser(age);
    }
}
