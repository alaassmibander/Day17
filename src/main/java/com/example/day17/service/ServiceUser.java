package com.example.day17.service;

import com.example.day17.Exceptions.ApiException;
import com.example.day17.Moudle.User;
import com.example.day17.Repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceUser {

    private final userRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User c) {
        return userRepository.save(c);
    }

    public Optional<User> updateUser(Integer id, User c) {
        if (userRepository.existsById(id)) {
            User chosenUser = userRepository.getById(id);
            chosenUser.setName(c.getName());
            chosenUser.setAge(c.getAge());
            chosenUser.setRole(c.getRole());
            chosenUser.setEmail(c.getEmail());
            chosenUser.setPassword(c.getPassword());
            chosenUser.setUsername(c.getUsername());
            return Optional.of(userRepository.save(chosenUser));
        }
        return Optional.empty();
    }

    public boolean removeUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public User findByEmail(String email){
        User user=userRepository.findUserByEmail(email);
        if (user==null){
            throw new ApiException("email not found");
        }
        return user;
    }
    public List<User> findUsersByRole(String role){
        User users=new ArrayList<>();
        for (User:
             ) {

        }
        User user=userRepository.findUsersByRole(role);
        if (user==null){
            throw new ApiException("no one has that role ");
        }
        return user;
    }
}
