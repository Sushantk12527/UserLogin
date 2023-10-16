package com.loginUser.loginUser.Repositories;

import com.loginUser.loginUser.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session,Long> {

        Session findByToken(String token);
        void delete(Session session);

}
