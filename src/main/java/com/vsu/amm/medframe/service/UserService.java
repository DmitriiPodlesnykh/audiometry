package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);
    void delete(Long id);
    User update(User user);
    User getOne(Long id);
    List<User> getAll();

}
