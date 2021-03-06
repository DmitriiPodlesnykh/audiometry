package com.vsu.amm.audiometry.service.impl;

import com.vsu.amm.audiometry.model.dto.UserDto;
import com.vsu.amm.audiometry.model.entity.User;
import com.vsu.amm.audiometry.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

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

    public UserDto getOne(Long id) {
        log.info("start UserDto getOne(Long id). id = " + id);
        User user = new User();
        try {
            user = userRepository.findOne(id);
            log.info("after User user = userRepository.findOne(id);");
            log.info("user = " + user.toString());
        } catch (Exception e) {
            log.info("fail. e = " + e.getMessage());
        }
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(dto.getEmail());
        dto.setFirstName(dto.getFirstName());
        dto.setPassword(user.getPassword());
        dto.setLastName(user.getLastName());
        dto.setMiddleName(user.getMiddleName());
        dto.setUserType(user.getUserType());
        //dto.setTemplates(user.get);
        return dto;
    }

    public User getUser(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
