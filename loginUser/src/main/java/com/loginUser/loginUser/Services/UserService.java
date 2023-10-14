package com.loginUser.loginUser.Services;

import com.loginUser.loginUser.Entities.User;

public interface UserService {
    void CreateUser(User user);

    String Login(String email, String password);

}
