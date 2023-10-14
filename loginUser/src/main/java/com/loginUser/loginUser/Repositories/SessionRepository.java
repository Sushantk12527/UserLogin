package com.loginUser.loginUser.Repositories;

import com.loginUser.loginUser.Entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {

}
