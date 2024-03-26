package cgg.datajpamappings.springbootdatajpamappingproj.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cgg.datajpamappings.springbootdatajpamappingproj.dao.UserRepository;
import cgg.datajpamappings.springbootdatajpamappingproj.entity.User;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initDB() {

        List<User> users = new ArrayList<>();
        users.add(new User(111, "x", "IT", 23));
        users.add(new User(675, "y", "IT", 24));
        users.add(new User(432, "z", "CIVIL", 26));
        users.add(new User(88, "p", "IT", 23));
        users.add(new User(654, "q", "GOVT", 20));

        this.userRepository.saveAll(users);
    }

    public List<User> getUsersByProfession(String profession) {
        return this.userRepository.findByProfession(profession);

    }

    public long getUserCount(int age){
        return this.userRepository.countByAge(age);
    }

    public long getTotalCount(){
        return this.userRepository.count();
    }

    @Transactional
    public List<User> deleteUserByName(String name){
        return this.userRepository.deleteByName(name);
    }

    public List<User> findUserByProfessionAndAge(String profession,int age){
        return this.userRepository.findByProfessionAndAge(profession, age);
    }
    public List<User> findUserByProfessionAndAgeIgnoreCase(String profession,int age){
        return this.userRepository.findByProfessionIgnoreCaseAndAge(profession, age);
    }

    public List<User> findByAgeSortedOnName(int age){
        return this.userRepository.findByAgeOrderByNameDesc(age);
    }

    //sort
    public List<User> findUsersWithSorting(String field){
        return this.userRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public List<User> findFirstUser(int age){
        return this.userRepository.findFirst1ByAge(age);
    }

    public List<User> getAllUsers(int offset,int pageSize){
        return this.userRepository.getUsersCustomQuery(PageRequest.of(offset, pageSize));
    }
    public List<User> getAllUsers1(String p,int offset,int pageSize){
        return this.userRepository.getUsersNativeQuery(p,PageRequest.of(offset, pageSize));
    }

    @Transactional
    public int updateUser(){
      return this.userRepository.updateUser();
    }
}
