package io.h2o.springsecurityjwt.repository;

import io.h2o.springsecurityjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}
