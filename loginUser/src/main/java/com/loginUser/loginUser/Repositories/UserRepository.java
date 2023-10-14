package com.loginUser.loginUser.Repositories;

import com.loginUser.loginUser.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailAndPassword(String email, String password);

}
