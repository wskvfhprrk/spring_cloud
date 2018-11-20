package com.hejz.shiro.repository;

import com.hejz.shiro.entity.User;
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
