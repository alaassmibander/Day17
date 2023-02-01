package com.example.day17.Repository;

import com.example.day17.Moudle.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    User findUserByEmail(String email);
    User findUsersByRole(String role);
    User findUserByUsernameAndPassword(String username,String password);
    User findByAgeGreaterThan(int age);

}
