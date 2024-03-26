package cgg.datajpamappings.springbootdatajpamappingproj.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cgg.datajpamappings.springbootdatajpamappingproj.entity.User;


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

   @Query("from User")
   List<User> getUsersCustomQuery(Pageable pageable);

   @Query(value="select * from user1 where profession = :p",
   countQuery = "select count(*) from user1 where profession=:p",nativeQuery = true)
   List<User> getUsersNativeQuery(@Param("p")String p,Pageable pageable);


   @Modifying
   @Query("update User set profession='CGG'")
   int updateUser();

}
