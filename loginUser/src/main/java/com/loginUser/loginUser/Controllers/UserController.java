package com.loginUser.loginUser.Controllers;

import com.loginUser.loginUser.Entities.User;
import com.loginUser.loginUser.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void CreateUser(@RequestBody User user) {
    userService.CreateUser(user);
}

    @PostMapping("/login")
    public String Login(@RequestParam String email, @RequestParam String password){
        return userService.Login(email,password);
    }

    @DeleteMapping("/logout")
    public void Logout(){

    }
}
