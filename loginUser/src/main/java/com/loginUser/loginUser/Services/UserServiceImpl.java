package com.loginUser.loginUser.Services;

import com.loginUser.loginUser.Entities.Session;
import com.loginUser.loginUser.Entities.User;
import com.loginUser.loginUser.Repositories.SessionRepository;
import com.loginUser.loginUser.Repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

import static java.lang.Math.random;

@Service
@Primary
public class UserServiceImpl implements UserService{

    private  UserRepository userRepository;
    private SessionRepository sessionRepository;

    String token;

    public UserServiceImpl(UserRepository userRepository , SessionRepository sessionRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;

    }

    @Override
    public void CreateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public String Login(String email, String password) {
       User userFound= userRepository.findByEmailAndPassword(email,password);
         if(userFound!=null){
             Session session=new Session();
            ;
             session.setToken( getSaltString());
             session.setUser(userFound);

             sessionRepository.save(session);

              return "Login Successful";
         }
         else{
              return "Login Failed";
         }
    }

    @Override
    public void Logout(String token) {

        Session session= sessionRepository.findByToken(token);
        sessionRepository.delete(session);


    }


    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }


}
