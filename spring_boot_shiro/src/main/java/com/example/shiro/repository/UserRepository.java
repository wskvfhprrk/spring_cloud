package com.example.shiro.repository;

import com.example.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 14:01
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
