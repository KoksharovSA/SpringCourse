package ru.gb.SpringCourseL1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.SpringCourseL1.model.User;
import ru.gb.SpringCourseL1.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.updateUser(user);
    }

    public User gtUserById(int id){
        return userRepository.getUserById(id);
    }
}
