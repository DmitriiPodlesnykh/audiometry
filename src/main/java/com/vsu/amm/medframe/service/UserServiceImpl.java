package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.entity.User;
import com.vsu.amm.medframe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    public void delete(Long id) {

    }

    public User update(User user) {
        return null;
    }

    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
