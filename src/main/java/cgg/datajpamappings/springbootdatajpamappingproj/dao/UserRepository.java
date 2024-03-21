package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    

    List<User> findByProfession(String profession);

    long countByAge(int age);

    List<User> deleteByName(String name);

    //multiple condition
    List<User> findByProfessionAndAge(String profession,int age);

    //ignore case
    List<User> findByProfessionIgnoreCaseAndAge(String profession,int age);    

   List<User> findByAgeOrderByNameDesc(int age);

   List<User> findFirst1ByAge(int age);
}
