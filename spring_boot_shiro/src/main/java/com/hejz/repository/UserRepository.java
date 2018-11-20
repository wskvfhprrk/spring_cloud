package com.hejz.repository;

import com.hejz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${VAR}
 *
 * @author 何建哲
 * @date 2018/11/19 14:01
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
