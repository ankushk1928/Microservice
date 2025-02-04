package com.adk.user.service.service;

import com.adk.user.service.entities.User;

import java.util.List;

/**
 * @author ankushk
 */
public interface UserService {

    User saveUser(User user);
    List<User> getAllUser();

    User getUser(String userId);

    User deleteUser(String userId);
    User updateUser(User user);
}
